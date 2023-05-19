import greenfoot.*;
import java.util.*;
public class Balthazar extends Player {

    
    
    public Balthazar() {
        super("Balthazar", 2, true, 300, 300, 
            "balthazar", 2, new GumBomb(), new BubbleGum(),
        new Keytar(), new BalthazarBot(), null, null);
    }
    public void c() {
        setCAbility(new GumBomb(facingRight()));
        getWorld().addObject(getCAbility(), 
            this.getX() + 38, this.getY() - 40);
        canCast = false;
    }
    public void e() {
        Keytar k = new Keytar(this);
        setEAbility(k);
        if(facingRight()) {
            getWorld().addObject(getEAbility(), 
                this.getX() + 90, this.getY() - 10);
        }
        else {
            getWorld().addObject(getEAbility(), 
                this.getX() - 90, this.getY() - 10);
        }
        canMove = false;
        canCast = false;
    }
    public void x() {
        setXAbility(new BalthazarBot());
        if(facingRight()) {
            getWorld().addObject(getUltimateAbility(), this.getX() + 300, 450);
        }
        else {
            getWorld().addObject(getUltimateAbility(), this.getX() - 300, 450);
        }
        canCast = false;
    }
    public void q() {
        setQAbility(new BubbleGum(facingRight()));
        getWorld().addObject(getQAbility(), 
            this.getX() + 38, this.getY() - 40);
    }
    public void singleFire() { 
        if(hasMachete()) {
            getWorld().addObject(new Machete(facingRight()), 
                this.getX(), this.getY());    
        }
    }
    public void burstFire() {
        if(hasMachete()) {
            getWorld().addObject(new BoomerangMachete(this, facingRight()), 
                this.getX(), this.getY());
        }
    }
    public void act() {
        super.act();
        checkAbilities();
    }
    private boolean hasMachete() {
        List<Machete> machetes = getWorld().getObjects(Machete.class);
        List<BoomerangMachete> boomerangMachetes 
            = getWorld().getObjects(BoomerangMachete.class);
        return machetes.size() == 0 && boomerangMachetes.size() == 0;
    }
    @Override
    public boolean intersects(Actor a) {
        return super.intersects(a);
    }
}