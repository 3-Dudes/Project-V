import greenfoot.*;
public class Vector extends Player {
    private CannonBlaster cannon;
    private Laser laser;
    private GreenfootImage img;
    public Vector() {
        img = this.getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        setImage(img);
        
        this.health = 120;
        this.setHealth(this.health);
        cannon = new CannonBlaster();
        laser = new Laser();
    }
    public void singleFire() { }
    public void burstFire() { }
    public void reload() { }
    public void c() { }
    public void e() { }
    public void x() {
        Greenfoot.playSound("ohyeah.wav");
        getWorld().addObject(cannon, this.getX() - 100, this.getY() + 35);
        Greenfoot.delay(200);
        getWorld().addObject(laser, cannon.getX() - cannon.getImage().getWidth() - 49, cannon.getY() + 6);
        laser.fire();
        Greenfoot.delay(300);
        getWorld().removeObject(laser);
        getWorld().removeObject(cannon);
    }
    public void shootCannon() {
        
    }
}