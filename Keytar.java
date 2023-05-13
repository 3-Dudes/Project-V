import java.util.*;
import greenfoot.*;
public class Keytar extends Ability {
    private Balthazar b;
    private int startX;
    private int startY;
    private int duration;
    public Keytar() {
        super(1500, 30);
        duration = 0;
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        startX = this.getX();
        startY = this.getY();
    }
    public Keytar(Balthazar b) {
        this();
        this.b = b;
    }
    public void act() {
        if(!isFinished) {
            b.setLocation(b.getX() + 15, b.getY());
            this.setLocation(b.getX() + 30, b.getY()); 
            setDamage(getDamage() + 2);
        }
        detectCollision("Balthazar");
        duration++;
        if(duration == 15) {
            isFinished = true;
            getWorld().removeObject(this);
            duration = 0;
            b.setLocation(startX, startY);
        }
    }
    @Override
    public void detectCollision(String name) {
        if(getWorld() != null) {
            List<Player> players = getObjectsInRange(getImage().getWidth() / 2, Player.class);
            for(Player hitPlayer : players) {
                if(hitPlayer != null && !intersects 
                    && !hitPlayer.getClass().getName().equals(name)) {
                    hitPlayer.decreaseHealth(getDamage());
                    intersects = true;
                }
            }
        }
    }
}