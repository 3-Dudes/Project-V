import greenfoot.*;
import java.util.*;
public class Gru extends Player {
    public Gru() {
        super("Gru", 2, false, 500, 500);
    }
    @Override
    public void addedToWorld(World w) {
        getWorld().addObject(new LaserRifle(this, 100, 0), 100, 0);
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
        
    }
    public void burstFire() {
        
    }   
}