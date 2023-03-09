import greenfoot.*;
public class Laser extends Weapon
{
    public Laser() {
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
    }    
    public void fire() {
        Greenfoot.playSound("lasershoot.mp3");
    }
}
