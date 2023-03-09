import greenfoot.*;
public class BubbleGum extends Ability
{
    private static GreenfootImage img;
    private boolean movingRight;
    public BubbleGum() {
        super(10, 10);
        img = this.getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        this.setImage(img);
        movingRight = true;
    }
    public void act() {
        if(this.isAtEdge()) {
            if(this.getX() == 0) {
                this.setLocation(this.getX() + 10, this.getY()); 
                movingRight = true;
            }
            else {
                this.setLocation(this.getX() - 10, this.getY());
                movingRight = false;
            }
        }
        else {
            if(movingRight) {
                this.setLocation(this.getX() + 10, this.getY());
            }
            else {
                this.setLocation(this.getX() - 10, this.getY());
            }
        }
    }
    public void pop() {
        getWorld().removeObject(this);
    }
}