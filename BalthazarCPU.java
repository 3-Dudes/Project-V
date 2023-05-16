import greenfoot.*;
import java.util.*;
public class BalthazarCPU extends CPU {
    public BalthazarCPU() {
        super("BalthazarCPU", 2, true, 300, 300, "balthazar", 2, new GumBomb(), new BubbleGum(),
            new Keytar(), null, null, null, super.getPlayerReference());
    }

    private Player getPlayerReference() {
        List<Player> players = getObjectsInRange(getWorld().getWidth(), Player.class);
        if(players.size == 1) {
            return players.get(0);
        }
        return null;
    }

    public void c() {
        setCAbility(new GumBomb());
        getWorld().addObject(getCAbility(), this.getX() + 38, this.getY() - 40);
    }

    public void e() {
        Keytar k = new Keytar(this);
        setEAbility(k);
        getWorld().addObject(getEAbility(), this.getX() + 30, this.getY());
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
        if(Player.getX()>this.getX()){ //if enemy is to right of T-9000
            super.isFacingRight=true;
        } else{ //player is to left of T-9000
            super.isFacingRight=false;
        }
        if(math.abs(Player.getX()-this.getX())>400){ // moves towards human if far
            if(super.isFacingRight){this.setLocation(this.getX() - 5, this.getY());} else{this.setLocation(this.getX() - 5, this.getY());}
        }

    }

}