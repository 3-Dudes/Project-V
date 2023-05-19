import greenfoot.*;
import java.util.*;
public class BalthazarBot extends UltimateAbility {
    private BrattBeam laser;
    private int duration;
    private int times;
    private boolean isFacingRight;
    public BalthazarBot() {
        laser = new BrattBeam(this);
        times = 0;
        duration = 0;
    }
    public BalthazarBot(boolean isFacingRight) {
        this();
        this.isFacingRight = isFacingRight;
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        getWorld().addObject(laser, this.getX() + 270, this.getY() - 95);
    }
    public void act() {
        duration++;
        if(duration % 20 == 0) {
            if(duration % 40 == 0) {
                getWorld().removeObject(laser);
            }
            else {
                getWorld().addObject(laser, this.getX() + 270, this.getY() - 95);
            }
        }
        if(duration == 120) {
            getWorld().removeObject(this);
            duration = 0;
            isFinished = true;
        }
    }
}