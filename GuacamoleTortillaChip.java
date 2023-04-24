import greenfoot.*;
public class GuacamoleTortillaChip extends Ability {
    private GreenfootImage rightImg;
    private GreenfootImage leftImg;
    private boolean right;
    public GuacamoleTortillaChip() {
        this(false);
    }
    public GuacamoleTortillaChip(boolean right) {
        super(800, 20);
        leftImg = this.getImage();
        leftImg.scale(leftImg.getWidth() / 7, leftImg.getHeight() / 7);
        rightImg = new GreenfootImage(leftImg);
        rightImg.mirrorHorizontally();
        this.right = right;
        if(right) {
            this.setImage(rightImg);
        }
    }

    @Override
    public void act() {
        super.act();
        if(right) {
            this.setImage(rightImg);
            this.setLocation(this.getX() + 8, this.getY());
        }
        else {
            this.setImage(leftImg);
            this.setLocation(this.getX() - 8, this.getY());
        }
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
        detectCollision("ElMacho");
    }
}