import greenfoot.*;
import java.util.List;
public class LaserRifle extends Weapon {
    private Gru g;
    private int spaceX;
    private int spaceY;
    private static GreenfootImage left;
    private static GreenfootImage right;
    public LaserRifle(Gru g, int spaceX, int spaceY) {
        super(g, spaceX, spaceY, 10, 10);
        this.g = g;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
        left = getImage();
        right = new GreenfootImage(left);
        right.mirrorHorizontally();
    }
    public void act() {
        if(g.facingRight()) {
            this.setImage(right);
        }
        else {
            this.setImage(left);
        }
        this.setLocation(g.getX() + 100, g.getY() + 50);
    }
    public boolean exists() {
        List<LaserRifle> laserRifles = 
            getWorld().getObjects(LaserRifle.class);
        return laserRifles.size() != 0;
    }
}
