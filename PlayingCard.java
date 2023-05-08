import greenfoot.*;
public class PlayingCard extends Ability {
    private int tracker = 0;
    public static GreenfootImage left;
    public static GreenfootImage right;
    private static int damage = 10;
    private boolean isRight;
    private boolean recast;
    public PlayingCard(boolean isRight) {
        super(1200, damage);
        tracker = 0;
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 9, img.getHeight() / 9);
        this.isRight = isRight;
        recast = false;
    }
    public void act() {
        move();
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
        detectCollision("Lucy");
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