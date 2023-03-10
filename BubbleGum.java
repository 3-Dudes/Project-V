import greenfoot.*;
public class BubbleGum extends Ability {
    private static GreenfootImage img;
    private boolean movingRight;
    private int bounces;
    public BubbleGum() {
        super(10, 10);
        img = this.getImage();
        bounces = 0;
        img.scale(img.getWidth() / 4, img.getHeight() / 4);
        this.setImage(img);
        movingRight = true;
    }
    public void act() {
        if(this.isAtEdge()) {
            if(this.getX() == 0) {
                this.setLocation(this.getX() + 10, this.getY() + 15); 
                movingRight = true;
            }
            else {
                this.setLocation(this.getX() - 10, this.getY() + 15);
                movingRight = false;
            }
            bounces++;
        }
        else {
            if(movingRight) {
                this.setLocation(this.getX() + 10, this.getY());
            }
            else {
                this.setLocation(this.getX() - 10, this.getY());
            }
        }
        if(bounces == 4) {
            this.pop();
        }
    }
    public void pop() {
        getWorld().removeObject(this);
    }
}