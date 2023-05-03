import greenfoot.*;
import java.util.*;
public class Flamethrower extends Weapon {
    private Lucy l;
    public Flamethrower(Lucy l, int spaceX, int spaceY) {
        super(l, spaceX, spaceY, 3);
        this.l = l;
        GreenfootImage img = getImage();
    }
    public boolean isFiring() {
        int offsetX = 30;
        if(!l.facingRight()) {
            offsetX = -offsetX;
        }
        if(l.hasFlamethrower()) {
            Fire fire = (Fire) getOneObjectAtOffset(offsetX, 0, Fire.class);
            return fire != null && fire.getX() >= this.getX();
        }
        return false;
    }
}
