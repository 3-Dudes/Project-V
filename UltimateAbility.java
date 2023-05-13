import greenfoot.*;
public abstract class UltimateAbility extends Actor {
    private int charge;
    protected boolean isFinished;
    public UltimateAbility() {
        charge = 0;
        isFinished = false;
    }
    public boolean isReady() {
        return charge == 100;
    }
    public void setCharge(int charge) {
        this.charge = charge;
    }
    public boolean isFinished() {
        return isFinished;
    }
}
