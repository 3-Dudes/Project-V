import greenfoot.*;
public class Laser extends Weapon
{
    public Laser() {
        super(new Vector(), 0, 0, 2, 2);
        GreenfootImage img = this.getImage();
    }    
    public void fire() {
        Greenfoot.playSound("lasershoot.mp3");
    }
}
