import greenfoot.*;
public class GuacamoleTortillaChip extends Ability {
    public GuacamoleTortillaChip() {
        super(800, 20);
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 5, img.getHeight() / 5);
        img.mirrorHorizontally();
        setImage(img);
    }
    public void act() {
        this.setLocation(this.getX() + 5, this.getY());
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}