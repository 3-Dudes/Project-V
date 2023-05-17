import greenfoot.*;
public class FreezeRayBlast extends Actor {
    private FreezeRay fr;
    private static GreenfootImage right;
    private static GreenfootImage left;
    public FreezeRayBlast(FreezeRay fr) {
        this.fr = fr;
        right = getImage();
        right.rotate(15);
        right.scale(right.getWidth() / 3, right.getHeight() / 3);
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
    }
    public void act() {
        if(fr.facingRight()) {
            this.setLocation(fr.getX() + 185, fr.getY() - 20);
            this.setImage(right);
        }
        else {
            this.setLocation(fr.getX() - 185, fr.getY() - 20);
            this.setImage(left);
        }
    }
    @Override
    public Actor getOneIntersectingObject(Class<?> cls) {
        return super.getOneIntersectingObject(cls);
    }
}
