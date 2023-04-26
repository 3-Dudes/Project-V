import greenfoot.*;
import java.util.*;
public class Balthazar extends Player {
    public Balthazar() {
        super("Balthazar", 2);
        health = 300;
        hitpoints = 300;
        q = new BubbleGum();
    }
    public void c() {
        
    }
    public void e() {
        
    }
    public void x() {
        
    }
    public void q() {
        getWorld().addObject(q, this.getX() + 38, this.getY() - 40);
        canCast = false;
    }
    public void singleFire() { }
    public void burstFire() { }
    public void reload() { }
    public void act() {
        super.act();
        checkAbilities();
    }
}