import greenfoot.*;
public class TortillaChip extends Weapon {
    private static int damage = 10;
    public static GreenfootImage img;
    public TortillaChip() {
        img = this.getImage();
        img.scale(img.getWidth() / 7, img.getHeight() / 7);
        img.mirrorHorizontally();
        setImage(img);
    }    
    public void act() {
        this.setLocation(this.getX() + 5, this.getY());
        detectCollision("ElMacho", damage);
    }
}