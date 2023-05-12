import greenfoot.*;
public class FlyingV_Start extends Actor {
    private int x;
    private StartButton button;
    public FlyingV_Start() {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        img.mirrorHorizontally();
        x = 0;
        button = new StartButton();
    }
    public void act() {
        this.setLocation(this.getX() + 15, this.getY());
        if(this.isAtEdge()) {
            getWorld().addObject(button, 610, 600);
            getWorld().removeObject(this);
        }
    }
}