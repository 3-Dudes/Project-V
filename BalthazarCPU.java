import greenfoot.*;
import java.util.*;
public class BalthazarCPU extends CPU {
    public BalthazarCPU() {
        super("BalthazarCPU", 2, true, 300, 300, "balthazar", 2, new GumBomb(), new BubbleGum(),
            new Keytar(), null, null, null);//, super.getPlayerReference());
    }

    private Player getPlayerReference() {
        List<Player> playerz 
            = getWorld().getObjectsAt(200, 700 - 175, Player.class);
        if(playerz.size() == 1) {
            return playerz.get(0);
        }
        return null;
    }
    private Player p;
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        p = getPlayerReference();
        pheight = p.getY();
    }

    public void c() {
        setCAbility(new GumBomb());
        getWorld().addObject(getCAbility(), this.getX() + 38, this.getY() - 40);
    }

    public void e() {
        Keytar k = new Keytar();
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
        boolean ultavailable=true;
        int move=0;
        int pheight;
    public void act() {
        super.act();
        checkAbilities();
        if(p.getX()>this.getX()){ //if enemy is to right of T-9000
            super.isFacingRight=true;
        } else{ //player is to left of T-9000
            super.isFacingRight=false;
        }
        if(Math.abs(p.getX()-this.getX())>400){ // moves towards human if far
            if(super.isFacingRight){this.setLocation(this.getX() - 5, this.getY());} else{this.setLocation(this.getX() - 5, this.getY());}
        }

        if( Math.abs(p.getX()-this.getX()) > 400 && (p.getX()-this.getX())<600){ // moves towards human if far
            int rand=Greenfoot.getRandomNumber(3);
            switch (move) {
                case 0:
                    singleFire();
                    break;
                case 1:
                    q();
                    break;
                case 2:
                    e();
                    break;
                default:
                    break;
            }
            if(super.isFacingRight){this.setLocation(this.getX() - 5, this.getY());} else{this.setLocation(this.getX() - 5, this.getY());}
        }
        else if(Math.abs(p.getX()-this.getX())>600){ // moves towards human if far
            q();
        }
        else{
            burstFire();
        }
        //detect if human jumps (WILL NEED FIX)
        if(p.getY()!=pheight){
            burstFire();
        }        
        //1 in 400,000 chance to jump every act method
        int rand1=Greenfoot.getRandomNumber(400001);
        if(rand1==69){
            //            jump();
            for(int i=0; i<10; i++){
                if(super.isFacingRight){this.setLocation(this.getX() + 5, this.getY());} 
                else{this.setLocation(this.getX() - 5, this.getY());}
            }
        }
        //use ult when half-health
        if(this.getHealth()<=150&&this.getHealth()>=75){
            x();
            ultavailable= false;
        }
        if(ultavailable==false&&this.getHealth()<=75){
            x();
            ultavailable=true;
        }
    }
}