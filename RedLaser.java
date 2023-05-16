import greenfoot.*;
public class RedLaser extends Actor {
    public RedLaser() {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
    }
    public void act() {
        this.setLocation(this.getX() + 10, this.getY());
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
    @Override
    public Actor getOneIntersectingObject(Class<?> cls) {
        return super.getOneIntersectingObject(cls);
    }
}
