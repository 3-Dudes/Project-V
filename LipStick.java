import greenfoot.*;
public class LipStick extends Ability {
    private Lighting charge;
    private Lucy l;
    public LipStick() {
        super(900, 10);
        charge = new Lighting();
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
    }
    public LipStick(Lucy l) {
        this();
        this.l = l;
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
