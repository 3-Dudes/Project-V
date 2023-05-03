import greenfoot.*;
import java.util.*;
public class Flamethrower extends Weapon {
    private Lucy l;
    public Flamethrower(Lucy l, int spaceX, int spaceY) {
        super(l, spaceX, spaceY, 3);
        GreenfootImage img = getImage();
    }
    public boolean isFiring() {
        Fire fire = (Fire) getOneObjectAtOffset(30, 0, Fire.class);
        return fire != null && fire.getX() >= this.getX();
    }
}
