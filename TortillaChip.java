import greenfoot.*;
public class TortillaChip extends Weapon {
    private static int damage = 10;
    public static GreenfootImage img;
    private boolean right;
    public TortillaChip(boolean right) {
        super(new ElMacho());
        this.right = right;
        img = this.getImage();
        img.scale(img.getWidth() / 7, img.getHeight() / 7);
        img.mirrorHorizontally();
        setImage(img);
    }    
    public void act() {
        if(right) {
            this.setLocation(this.getX() + 5, this.getY());
        }
        else {
            //getImage().mirrorHorizontally();
            this.setLocation(this.getX() - 5, this.getY());    
        }
        detectCollision("ElMacho", damage);
    }
}