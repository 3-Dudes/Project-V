import greenfoot.*;
public class CannonBlaster extends Weapon {
    private int charge = 0;
    private Laser laser;
    public CannonBlaster() {
        super(new Vector());
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        setImage(img);
    }
    public int getCharge() {
        return charge;
    }
    public void setCharge(int x) {
        charge = x;
    }
}