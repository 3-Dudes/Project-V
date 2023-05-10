import greenfoot.*;
public class FlyingV extends UltimateAbility {
    private static GreenfootImage left;
    private static GreenfootImage right;
    private boolean hitEdge;
    private Vector v;
    private int startX;
    private int startY;
    public FlyingV(Vector v) {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        this.v = v;
        hitEdge = false;
        v.setImage(img);
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        startX = v.getX();
        startY = v.getY();
        v.setRotation(135);
        right = new GreenfootImage(v.getImage());
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
        v.setImage(left);
        v.setLocation(v.getX(), 100);
        this.setImage((GreenfootImage) null);
    }
    public void act() {
        if(hitEdge) {
            v.setLocation(v.getX() + 5, v.getY() - 10);
        }
        else {
            v.setLocation(v.getX() + 5, v.getY() + 10);
        }
        if(v.isAtEdge()) {
            if(v.getY() == getWorld().getHeight() - 1) {
                v.setRotation(50);
                hitEdge = true;
            }
            if(v.getY() == 0) {
                isFinished = true;
            }
        }
        if(isFinished()) {
            v.setLocation(startX, startY);
            v.setRotation(0);
            if(v.facingRight()) {
                v.setImage(v.getRightImage());
            }
            else {
                v.setImage(v.getLeftImage());
            }
            setCharge(0);
            v.canMove = true;
            v.canCast = true;
        }
    }
}