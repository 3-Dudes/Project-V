import greenfoot.*;
public class FlyingV extends UltimateAbility {
    private static GreenfootImage left;
    private static GreenfootImage right;
    public FlyingV() {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        right = new GreenfootImage(img);
        left = new GreenfootImage(right);
        left.mirrorVertically();
        this.setImage(left);
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        this.setLocation(this.getX(), 100);
        this.setRotation(-40);
    }
    public void act() {
        this.setLocation(this.getX() + 5, this.getY() + 20);
        if(this.isAtEdge()) {
            if(this.getY() == getWorld().getHeight() - 1) {
                this.setImage(right);
                this.setLocation(this.getX() + 5, this.getY() - 20);
            }
            if(this.getY() == 0) {
                setCharge(0);
            }
        }
    }
}