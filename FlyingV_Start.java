import greenfoot.*;
public class FlyingV_Start extends Actor {
    public FlyingV_Start() {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        img.mirrorHorizontally();
    }
    public void act()
    {
        this.setLocation(this.getX() + 15, this.getY());
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
    public boolean isRemoved() {
        return this == null;
    }
}