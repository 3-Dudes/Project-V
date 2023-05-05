import greenfoot.*;
public class CannonBlaster extends Weapon {
    private int charge = 0;
    private Laser laser;
    public CannonBlaster() {
        super(new Vector(), 0, 0, 3, 3);
        GreenfootImage img = this.getImage();
        setImage(img);
    }
    public int getCharge() {
        return charge;
    }
    public void setCharge(int x) {
        charge = x;
    }
}