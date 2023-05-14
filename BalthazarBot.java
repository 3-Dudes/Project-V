import greenfoot.*;
public class BalthazarBot extends UltimateAbility {
    private BrattBeam laser;
    private int duration;
    private int times;
    public BalthazarBot() {
        laser = new BrattBeam(this);
        times = 0;
        duration = 0;
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        getWorld().addObject(laser, this.getX() + 270, this.getY() - 95);
    }
    public void act() {
        if(duration == 5) {
            getWorld().removeObject(this);
            laser = new BrattBeam(this);
            duration = 0;
        }
        else {
            getWorld().addObject(laser, this.getX() + 270, this.getY() - 95);
        }
        if(times == 4) {
            isFinished = true;
        }
        duration++;
    }
}