import greenfoot.*;
public abstract class UltimateAbility extends Actor {
    private int charge;
    public UltimateAbility() {
        charge = 0;
    }
    public boolean isReady() {
        return charge == 100;
    }
    public void setCharge(int charge) {
        this.charge = charge;
    }
}
