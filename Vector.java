import greenfoot.*;
public class Vector extends Player {
    public Vector() {
        super("Vector", 3, false, 300 , 300, "vector", 6);
    }
    @Override
    public void c() {
        
    }
    @Override
    public void q() {
        
    }
    @Override
    public void e() {
        
    }
    @Override
    public void x() {
        this.setImage((GreenfootImage) null);
        getWorld().addObject(new FlyingV(this), 300, 100);
        canCast = false;
        canMove = false;
    }
    @Override
    public void singleFire() {
        
    }
    @Override
    public void burstFire() {
            
    }
}