import greenfoot.*;
import java.util.*;
public class Balthazar extends Player {
    public Balthazar() {
        super("Balthazar", 2, true, 300, 300, "balthazar", 2, null, new BubbleGum(),
        null, null, null, null);
    }
    public void c() {
        
    }
    public void e() {
        
    }
    public void x() {
        
    }
    public void q() {
        setQAbility(new BubbleGum());
        getWorld().addObject(getQAbility(), this.getX() + 38, this.getY() - 40);
    }
    public void singleFire() { }
    public void burstFire() { }
    public void reload() { }
    public void act() {
        super.act();
        checkAbilities();
    }
}