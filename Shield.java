import greenfoot.*;
public class Shield extends Actor
{
    public Shield() {
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
    }
    public void act() 
    {
        if(this.isTouching(Weapon.class) || this.isTouching(Ability.class)) {
            
        }
    }    
}