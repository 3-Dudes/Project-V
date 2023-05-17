import greenfoot.*;
import java.util.*;
public class Gru extends Player {
    private LaserRifle mainWeapon;
    private FreezeRay freezeRayGun;
    private boolean burstFireActivated;
    public Gru() {
        super("Gru", 2, false, 500, 500, "gru", 5);
        mainWeapon = new LaserRifle(this, 100, 40);
        FreezeRay fr = new FreezeRay(this);
        setQAbility(fr);
        burstFireActivated = false;
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        if(facingRight()) {
            getWorld().addObject(mainWeapon, this.getX() + 100, 
                this.getY() - 40);
            mainWeapon.setImage(mainWeapon.getRightImage());
        }
        else {
            getWorld().addObject(mainWeapon, this.getX() - 100, 
                this.getY() - 40);
            mainWeapon.setImage(mainWeapon.getLeftImage());
        }
    }
    public void c() {
        if(this.isTouching(LaserRifle.class)) {
            getWorld().removeObject(mainWeapon);
        }    
    }
    public void q() {
        if(this.isTouching(LaserRifle.class)) {
            getWorld().removeObject(mainWeapon);
        }
        if(facingRight()) {
            getWorld().addObject(getQAbility(), this.getX() + 100, 
                this.getY() - 30);    
        }
        else {
            getWorld().addObject(getQAbility(), this.getX() - 100,
                this.getY() - 30);
        }
    }
    public void e() {
        
    }
    public void x() {
        
    }
    public void singleFire() {
        if(this.isTouching(LaserRifle.class)) {
            if(facingRight()) {
                getWorld().addObject(new RedLaser(this), 
                mainWeapon.getX() + 110, mainWeapon.getY() - 15);    
            }
            else {
                getWorld().addObject(new RedLaser(this), 
                mainWeapon.getX() - 110, mainWeapon.getY() - 15);
            }    
        }
    }
    public void burstFire() {
        
    }   
    public void act() {
        super.act();
        if(!this.isTouching(Weapon.class) 
            && !this.isTouching(Ability.class)) {
            mainWeapon = new LaserRifle(this, 100, 40);
            if(facingRight()) {
                getWorld().addObject(mainWeapon, this.getX() + 100, 
                    this.getY() - 30);
            }
            else {
                getWorld().addObject(mainWeapon, this.getX() - 100, 
                    this.getY() - 30);
            }
        }
    }
}