import greenfoot.*;
import java.util.*;
public class Lucy extends Player {
    private Flamethrower weapon;
    private static final int spaceX = 50;
    private static final int spaceY = 20;
    private int ultTimer = 0;
    private List<Weapon> weaponCycle;
    private int weaponIndex;
    private AmmoGUI ammoGui;
    public Lucy() {
        super("Lucy", 2);
        GreenfootImage img = this.getImage();
        health = 400;
        hitpoints = 400;
        weapon = new Flamethrower(this, spaceX, spaceY);
        weaponIndex = 0;
        //img.scale(img.getWidth() / 2, img.getHeight() / 2);
        weaponCycle = new ArrayList<Weapon>();
        weaponCycle.add(new Unicorn(facingRight()));
        weaponCycle.add(new LipGloss(facingRight()));
        GreenfootImage defaultImg = getCurrentWeapon().getRightUnscaledImage();
        ammoGui = new AmmoGUI(7, 7, defaultImg, pastHalfway, 45, 2, 2);
    }
        
    public Weapon getCurrentWeapon() {
        return weaponCycle.get(weaponIndex);
    }
    
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        if(pastHalfway) {
            this.setImage(getLeftImage());
            getWorld().addObject(ammoGui, 1200, 425);
        }
        else {
            this.setImage(getRightImage());
            getWorld().addObject(ammoGui, 44, 425);
        }
    }
    
    public boolean hasFlamethrower() {
        int offsetX = 30;
        if(!facingRight()) {
            offsetX = -offsetX;
        }
        Flamethrower f 
            = (Flamethrower) this.getOneObjectAtOffset(offsetX, 0, 
            Flamethrower.class);
        return f != null;
    }
    
    public void act() {
        super.act();
        if(ammoGui.cur <= 0) {
            reload();
        }
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
        weaponIndex++;
        if(weaponIndex == 2) {
            weaponIndex = 0;
        }
        getWorld().removeObject(ammoGui);
        GreenfootImage defaultImg = getCurrentWeapon().getRightUnscaledImage();
        switch(weaponIndex) {
            case 0:
                ammoGui = new AmmoGUI(7, 7, defaultImg, pastHalfway,
                45, 2, 2);
                break;
            case 1:
                ammoGui = new AmmoGUI(4, 4, defaultImg, pastHalfway,
                95, 3, 4);
                break;
        }
        if(pastHalfway) {
            getWorld().addObject(ammoGui, 1200, 425);
        }
        else {
            getWorld().addObject(ammoGui, 44, 425);
        }
    }
    public void burstFire() {
        
    }
    public void singleFire() {
        if(ammoGui.cur > 0) {
            switch(weaponIndex) {
                case 0:
                    weaponCycle.set(weaponIndex, new Unicorn(facingRight()));
                    break;
                case 1:
                    weaponCycle.set(weaponIndex, new LipGloss(facingRight()));
                    break;
            }
            Weapon w = getCurrentWeapon();
            getWorld().addObject(w, this.getX(), this.getY());
            ammoGui.loseChip();
        }
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
                getWorld().addObject(weapon, this.getX() + spaceX, 
                    this.getY() - spaceY);
            }
            else {
                weapon.getImage().mirrorHorizontally();
                getWorld().addObject(weapon, this.getX() - spaceX, 
                    this.getY() - spaceY);
            }
        }
    }
}