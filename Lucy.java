import greenfoot.*;
import java.util.*;
public class Lucy extends Player {
    private Flamethrower weapon;
    private Fire ammo;
    public Lucy() {
        super("Lucy", 2);
        GreenfootImage img = this.getImage();
        health = 300;
        hitpoints = 300;
        //img.scale(img.getWidth() / 2, img.getHeight() / 2);
    }
    
    public boolean hasFlamethrower() {
        int offsetX = 30;
        if(!facingRight()) {
            offsetX = -offsetX;
        }
        Flamethrower f 
            = (Flamethrower) getOneObjectAtOffset(offsetX, 0, Flamethrower.class);
        return f != null;
    }
    
    public void act() {
        super.act();
    }
    @Override
    protected void castX() {
        if(Greenfoot.isKeyDown("X")) {
            x();
        }
        else {
            getWorld().removeObject(weapon);
            getWorld().removeObject(ammo);
        }
    }
    
    public void reload() {
        
    }
    public void burstFire() {
        
    }
    public void singleFire() {
        
    }
    public void c() {
        
    }
    public void q() {
        
    }
    public void e() {
        
    }
    public void x() {
        int spaceX = 50;
        int spaceY = 20;
        weapon = new Flamethrower(this, spaceX, spaceY);
        ammo = new Fire(weapon, this);
        if(!this.hasFlamethrower()) {
            if(facingRight()) {
                getWorld().addObject(weapon, this.getX() + spaceX, this.getY() - spaceY);
            }
            else {
                weapon.getImage().mirrorHorizontally();
                getWorld().addObject(weapon, this.getX() - spaceX, this.getY() - spaceY);
            }
            if(!weapon.isFiring()) {
                if(facingRight()) {
                    getWorld().addObject(ammo, weapon.getX() + 95, weapon.getY());
                }
                else {
                    ammo.getImage().mirrorHorizontally();
                    getWorld().addObject(ammo, weapon.getX() - 95, weapon.getY());
                }
            }
        }
    }
}