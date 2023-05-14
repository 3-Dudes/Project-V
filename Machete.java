import greenfoot.*;
public class Machete extends Weapon {
    private static GreenfootImage left;
    private static GreenfootImage right;
    private boolean bool;
    public Machete() {
        super(4, 4);
        left = getImage();
        right = new GreenfootImage(left);
        right.mirrorHorizontally();
    }
    public Machete(boolean bool) {
        this();
        this.bool = bool;
    }
    public void act() {
        if(bool) {
            this.setImage(right);
            this.setLocation(this.getX() + 10, this.getY());    
        }
        else {
            this.setImage(left);
            this.setLocation(this.getX() - 10, this.getY());
        }
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
        detectCollision("Balthazar", 10);
    }
}