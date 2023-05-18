import greenfoot.*;
import java.util.*;
public class Rocket extends Weapon
{
    private Gru g;
    private boolean right;
    public Rocket(Gru g, int spaceX, int spaceY, boolean right) {
        super(g, spaceX, spaceY, false, 10, 10);
        this.right=right;
    }

    public void act() {
        super.act();
        if(right){
            this.setLocation(this.getX()+5,this.getY());
        }
        else{
            this.setLocation(this.getX()-5,this.getY());
        }
        setDamage(10);
        detectCollision("Gru", getDamage());
    }
}
