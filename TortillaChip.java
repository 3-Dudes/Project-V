import greenfoot.*;
public class TortillaChip extends Weapon {
    public static int damage = 8;
    public TortillaChip() {
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
        if(getWorld() != null) {
            Player player = (Player) this.getOneIntersectingObject(Player.class);
            if(player != null) {
                player.decreaseHealth(damage);
            }
        }
    }
}