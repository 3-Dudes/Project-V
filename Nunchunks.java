import greenfoot.*;
public class Nunchunks extends Weapon {
    private int tracker = 0;
    private int ammo = 7;
    public static GreenfootImage left;
    public static GreenfootImage right;
    private boolean isRight;
    public Nunchunks(boolean isRight) {
        super(4, 4);
        tracker = 0;
        this.isRight = isRight;
    }
    public void act() {
        move();
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
        detectCollision("Lucy", 3);
    }
    public void move() {
        switch(tracker) {
            case 5:
                this.setRotation(90);
                break;
            case 10:
                this.setRotation(180);
                break;
            case 15:
                this.setRotation(270);
                break;
            case 20:
                this.setRotation(360);
                break;
            case 25:
                tracker = 0;
                this.setRotation(0);
                break;
        }
        tracker++;
        if(isRight) {
            this.setLocation(this.getX() + 10, this.getY());    
        }
        else {
            this.setLocation(this.getX() - 10, this.getY());
        }
    }
}
