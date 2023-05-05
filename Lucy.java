import greenfoot.*;
import java.util.*;
public class Lucy extends Player {
    private Flamethrower weapon;
    private static final int spaceX = 50;
    private static final int spaceY = 20;
    private int ultTimer = 0;
    public Lucy() {
        super("Lucy", 2);
        GreenfootImage img = this.getImage();
        health = 300;
        hitpoints = 300;
        weapon = new Flamethrower(this, spaceX, spaceY);
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
        if(this.hasFlamethrower()) {
            ultTimer++;
            if(ultTimer == 500) {
                getWorld().removeObject(weapon.getAmmo());
                getWorld().removeObject(weapon);
                ultTimer = 0;
                canCast = true;
            }
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
        canCast = false;
        if(!this.hasFlamethrower()) {
            if(facingRight()) {
                getWorld().addObject(weapon, this.getX() + spaceX, this.getY() - spaceY);
            }
            else {
                weapon.getImage().mirrorHorizontally();
                getWorld().addObject(weapon, this.getX() - spaceX, this.getY() - spaceY);
            }
        }
    }
}