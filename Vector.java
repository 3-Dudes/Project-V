import greenfoot.*;
import java.util.*;
public class Vector extends Player {
    private CannonBlaster cannon;
    private Laser laser;
    private GreenfootImage img;
    private PiranhaGun gun;
    public Vector() {
        super("Vector");
        img = this.getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        this.setImage(img);
        this.health = 200;
        
        gun = new PiranhaGun();
        cannon = new CannonBlaster();
        laser = new Laser();
    }
    public void singleFire() { }
    public void burstFire() { }
    public void reload() { }
    public void c() { }
    public void e() { }
    public void q() { }
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
}