import greenfoot.*;
public class GuacamoleTortillaChip extends Ability {
    public GuacamoleTortillaChip() {
        super(800, 20);
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 7, img.getHeight() / 7);
        img.mirrorHorizontally();
        this.setImage(img);
    }
    public void act() {
        super.act();
        this.setLocation(this.getX() + 8, this.getY());
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
        detectCollision("ElMacho");
    }
}