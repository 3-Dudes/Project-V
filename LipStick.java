import greenfoot.*;
public class LipStick extends Ability {
    private Lighting charge;
    private Lucy l;
    public LipStick(Lucy l) {
        super(900, 10);
        this.l = l;
        charge = new Lighting();
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        getWorld().addObject(charge, this.getX() + 130, this.getY());
    }
    public void act() {
        if(l.facingRight()) {
            this.setLocation(l.getX() + 70, l.getY() + 16);
        }
        else {
            this.setLocation(l.getX() - 70, l.getY() + 16);
        }
    }
}
