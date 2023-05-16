import greenfoot.*;
public class FreezeRayBlast extends Actor {
    private FreezeRay fr;
    public FreezeRayBlast(FreezeRay fr) {
        this.fr = fr;
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
    }
    public void act() {
        this.setLocation(fr.getX() + 185, fr.getY() - 20);
    }
    @Override
    public void addedToWorld(World w) {
        this.setRotation(15);
    }
    @Override
    public Actor getOneIntersectingObject(Class<?> cls) {
        return super.getOneIntersectingObject(cls);
    }
}
