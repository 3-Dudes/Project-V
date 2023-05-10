import greenfoot.*;
public class Vector extends Player {
    private GreenfootImage vectorFly;
    public Vector() {
        super("Vector", 3, false, 300 ,300, "vector", 6);
        vectorFly = new GreenfootImage("vector_fly.png");
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
    }
    @Override
    public void singleFire() {
        
    }
    @Override
    public void burstFire() {
        
    }
}