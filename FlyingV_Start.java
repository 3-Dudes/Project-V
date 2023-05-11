import greenfoot.*;
public class FlyingV_Start extends Actor {
    public FlyingV_Start() {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        img.mirrorHorizontally();
    }
    public void act() {
        this.setLocation(this.getX() + 10, this.getY());
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
            StartButton button = new StartButton();
            System.out.println(getWorld());
            getWorld().addObject(button, 380, 500);
        }
    }
}