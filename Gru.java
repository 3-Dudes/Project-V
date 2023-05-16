import greenfoot.*;
import java.util.*;
public class Gru extends Player {
    private Weapon mainWeapon;
    public Gru() {
        super("Gru", 2, false, 500, 500);
        mainWeapon = new LaserRifle(this, 100, 0);
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        getWorld().addObject(mainWeapon, this.getX() + 100, 
        this.getY() + 50);
    }
    public void c() {
            
    }
    public void q() {
        FreezeRay fr = new FreezeRay(this);
        setQAbility(fr);
        getWorld().addObject(getQAbility(), 
            this.getX() + 100, this.getY());
    }
    public void e() {
        
    }
    public void x() {
        
    }
    public void singleFire() {
        getWorld().addObject(new RedLaser(), mainWeapon.getX() + 100, mainWeapon.getY() - 20);
    }
    public void burstFire() {
        
    }   
    public void act() {
        super.act();
    }
    /* private boolean hasMainWeapon() {
        List<Weapon> weapons = getWorld().getObjects(Weapon.class);
        for(Weapon w : weapons) {
            return w.isTouching(Gru.class);
        }
        return false;
    } */
}