import greenfoot.*;
public class FlyingV_Start extends Actor {
    private int x;
    public FlyingV_Start() {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        img.mirrorHorizontally();
        x = 0;
    }
    public void act() {
        this.setLocation(this.getX() + 15, this.getY());
        if(this.isAtEdge()) {
            StartButton button = new StartButton();
            getWorld().addObject(button, 610, 600);
            getWorld().removeObject(this);
        }
    }
}