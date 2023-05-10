import greenfoot.*;
public class FlyingV extends UltimateAbility {
    public FlyingV() {
        this.setLocation(this.getX(), 100);
        this.setRotation(120);
    }
    public void act() {
        this.setLocation(this.getX() + 5, this.getY() + 10);
        if(this.isAtEdge()) {
            if(this.getY() == getWorld().getHeight() - 1) {
                this.setRotation(300);
                this.setLocation(this.getX() + 5, this.getY() - 10);
            }
            if(this.getY() == 0) {
                setCharge(0);
            }
        }
    }
}