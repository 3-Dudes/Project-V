import java.util.*;
import greenfoot.*;
public class Keytar extends Ability {
    private Balthazar b;
    private int startX;
    private int startY;
    private boolean shouldRemove;
    private static GreenfootImage left;
    private static GreenfootImage right;
    public Keytar() {
        super(1500, 30);
        GreenfootImage right = getImage();
        right.scale(right.getWidth() / 3, right.getHeight() / 3);
        GreenfootImage left = new GreenfootImage(right);
        left.mirrorHorizontally();
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
        if(!isFinished) {
            if(b.facingRight()) {
                b.setLocation(b.getX() + 15, b.getY());    
                this.setLocation(b.getX() + 30, b.getY());
            }
            else {
                b.setLocation(b.getX() - 15, b.getY());
                this.setLocation(b.getX() - 30, b.getY());
            }
            setDamage(getDamage() + 2);
        }
        detectCollision("Balthazar");
        if(shouldRemove || this.isAtEdge()) {
            isFinished = true;
            getWorld().removeObject(this);
            b.setLocation(startX, startY);
        }
    }
    @Override
    public void detectCollision(String name) {
        if(getWorld() != null) {
            if(hitPlayer != null && !intersects
                    && !hitPlayer.getClass().getName().equals(name)) {
                hitPlayer.decreaseHealth(getDamage());
                intersects = true;
                shouldRemove = true;
            }
        }
    }
}