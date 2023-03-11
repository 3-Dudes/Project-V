import greenfoot.*;
import java.util.*;
public class Balthazar extends Player {
    public Balthazar() {
        GreenfootImage thisImg = this.getImage();
        thisImg.scale(thisImg.getWidth() / 2, thisImg.getHeight() / 2);
        setImage(thisImg);
        q = new BubbleGum();
        e = new GuacamoleTortillaChip();
    }
    public void c() {
        
    }
    public void e() {
        
    }
    public void x() {
        
    }
    public void q() {
        if(q.abilityReady()) {
            q = new BubbleGum();
            getWorld().addObject(q, this.getX() + 38, this.getY() - 40);
        }
    }
    public void singleFire() { }
    public void burstFire() { }
    public void reload() { }
    public void act() {
        super.act();
        checkAbilities();
    }
}