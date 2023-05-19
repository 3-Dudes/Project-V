import greenfoot.*;
import java.util.*;
public class Flamethrower extends Weapon {
    private Lucy l;
    private Fire ammo;
    public Flamethrower(Lucy l, int spaceX, int spaceY) {
        super(l, spaceX, spaceY, true, 3, 3);
        this.l = l;
        ammo = new Fire(this, l);
        GreenfootImage img = getImage();
    }
    public Fire getAmmo() {
        return ammo;
    }
    public void act() {
        super.act();
        setDamage(1);
        detectCollision("Lucy", getDamage());
    }
    public boolean isFiring() {
        int offsetX = 50;
        if(!l.facingRight()) {
            offsetX = -offsetX;
        }
        if(l.hasFlamethrower()) {
            Fire fire = (Fire) getOneObjectAtOffset(offsetX, 0, Fire.class);
            return fire != null && fire.getX() >= this.getX();
        }
        return false;
    }
    @Override
    public void detectCollision(String name, int damage) {
        if (getWorld() != null && l.hasFlamethrower()) {
            int offsetX = 50;
            if (!l.facingRight()) {
                offsetX = -offsetX;
            }
            Player p = (Player) getOneObjectAtOffset(offsetX, 0, Player.class);
            if (p != null && !(p.getClass().getName().equals(name)) 
                && !(p instanceof Lucy)) {
                p.decreaseHealth(getDamage());
            }
        }
    }
    @Override
    public void addedToWorld(World w) {
        if(!isFiring()) {
            if(l.facingRight()) {
                getWorld().addObject(ammo, this.getX() + 85, this.getY());
            }
            else {
                ammo.getImage().mirrorHorizontally();
                getWorld().addObject(ammo, this.getX() - 85, this.getY());
            }
        }
    }
}