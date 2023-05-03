import greenfoot.*;
public class Fire extends Actor {
    private Flamethrower weapon;
    private Lucy holder;
    private GreenfootImage left;
    private GreenfootImage right;
    public Fire(Flamethrower f, Lucy l) {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        img.mirrorHorizontally();
        weapon = f;
        holder = l;
        left = getImage();
        right = new GreenfootImage(left);
        right.mirrorHorizontally();
    }
    public void act() {
        if(holder.facingRight()) {
            this.setImage(left);
            this.setLocation(weapon.getX() + 75, weapon.getY());
        }
        else {
            this.setImage(right);
            this.setLocation(weapon.getX() - 75, weapon.getY());    
        }
    }
}
