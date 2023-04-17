import greenfoot.*;
public class Laser extends Weapon
{
    public Laser() {
        super(new Vector());
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
    }    
    public void fire() {
        Greenfoot.playSound("lasershoot.mp3");
    }
}
