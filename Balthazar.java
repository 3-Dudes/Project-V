import greenfoot.*;
import java.util.*;
public class Balthazar extends Player
{
    private boolean cPressed;
    public Balthazar() {
        GreenfootImage thisImg = this.getImage();
        thisImg.scale(thisImg.getWidth() / 2, thisImg.getHeight() / 2);
        setImage(thisImg);
        cPressed = false;
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
        World w = getWorld();
        List<BubbleGum> inWorld = w.getObjects(BubbleGum.class);
        System.out.println(inWorld.size());
        if(inWorld.size() == 0) {
            w.addObject(q, this.getX() + 38, this.getY() - 40);
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