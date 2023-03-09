import greenfoot.*;
public class BubbleGum extends Ability
{
    private static GreenfootImage img;
    private boolean crossedEdge;
    public BubbleGum() {
        super(10, 10);
        img = this.getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        this.setImage(img);
        crossedEdge = false;
    }
    public void act() {
        if(this.isAtEdge()) {
            crossedEdge = true;
        }
        if(crossedEdge) {
            if(this.getX() == getWorld().getWidth() - 10) {
                this.setLocation(this.getX() - 5, this.getY());    
            }
        }
        else {
            this.setLocation(this.getX() + 5, this.getY());
        }
    }
    public void pop() {
        getWorld().removeObject(this);
    }
}