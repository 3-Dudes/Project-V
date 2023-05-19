import java.util.*;
import greenfoot.*;
public class Keytar extends Ability {
    private Balthazar b;
    private int startX;
    private int startY;
    private boolean spawnedIn;
    private boolean shouldRemove;
    private static GreenfootImage left;
    private static GreenfootImage right;
    private GreenfootSound charge = new GreenfootSound("hitcharge-94996.mp3");
    public Keytar() {
        super(1500, 30);
        right = getImage();
        right.scale(right.getWidth() / 3, right.getHeight() / 3);
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
        this.setImage(right);
        shouldRemove = false;
        intersects = false;
    }   
    public Keytar(Balthazar b) {
        this();
        this.b = b;
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        startX = this.getX();
        startY = this.getY();
    }
    public void act() {
        if(this.exists()) {
            spawnedIn = true;
        }
        if(spawnedIn) {
            charge.play();
        }
        if(!isFinished) {
            if(b != null) {
                if(b.facingRight()) {
                    this.setImage(right);
                    b.setLocation(b.getX() + 15, b.getY());    
                    this.setLocation(b.getX() + 90, b.getY() - 10);
                }
                else {
                    this.setImage(left);
                    b.setLocation(b.getX() - 15, b.getY());
                    this.setLocation(b.getX() - 90, b.getY() - 10);
                }    
            }
            setDamage(getDamage() + 2);
        }
        detectCollision("Balthazar");
        if(shouldRemove || this.isAtEdge()) {
            isFinished = true;
            getWorld().removeObject(this);
            b.setLocation(startX, startY);
            charge.stop();
        }
    }
    @Override
    public void detectCollision(String name) {
        if(getWorld() != null) {
            List<Player> intersectingObjs = 
                this.getIntersectingObjects(Player.class);
            for(int i = 0; i < intersectingObjs.size(); i++) {
                if(intersectingObjs.get(i) instanceof Balthazar) {
                    intersectingObjs.remove(i);
                }
            }
            for(Player p : intersectingObjs) {
                if(b.intersects(p) && !intersects) {
                    shouldRemove = true;
                    p.decreaseHealth(getDamage());
                    intersects = true;
                }
            }
        }
    }
    public boolean exists() {
        return getWorld() != null;
    }
}