import greenfoot.*;
import java.util.*;
public class BalthazarBot extends UltimateAbility {
    private BrattBeam laser;
    private int duration;
    private int times;
    private boolean isFacingRight;
    private static GreenfootImage left;
    private static GreenfootImage right;
    public BalthazarBot() {
        laser = new BrattBeam(this);
        right = getImage();
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
        times = 0;
        duration = 0;
    }
    public BalthazarBot(boolean isFacingRight) {
        this();
        this.isFacingRight = isFacingRight;
    }
    public boolean facingRight() {
        return isFacingRight;
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        if(facingRight()) {
            this.setImage(right);
            getWorld().addObject(laser, this.getX() + 270, this.getY() - 25);
        }
        else {
            this.setImage(left);
            getWorld().addObject(laser, this.getX() - 270, this.getY() - 25);
        }
    }
    public void act() {
        if(isFacingRight) {
            this.setImage(right);
        }
        else {
            this.setImage(left);
        }
        duration++;
        if(duration % 20 == 0) {
            if(duration % 40 == 0) {
                getWorld().removeObject(laser);
            }
            else {
                getWorld().addObject(laser, this.getX() + 270, this.getY() - 25);
            }
        }
        if(duration == 120) {
            getWorld().removeObject(this);
            duration = 0;
            isFinished = true;
        }
    }
}