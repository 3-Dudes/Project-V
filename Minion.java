import greenfoot.*;
public class Minion extends Ability {
    private GreenfootImage img;
    public Minion() {
        super(10, null);
        img = this.getImage();
        img.scale(img.getWidth() / 4, img.getWidth() / 4);
    }
    public void act() {
        
    }    
}
