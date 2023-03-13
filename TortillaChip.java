import greenfoot.*;
public class TortillaChip extends Weapon {
    private static int damage = 10;
    public TortillaChip() {
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 7, img.getHeight() / 7);
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
            if(player != null && !(player instanceof ElMacho)) {
                player.decreaseHealth(damage);
            }
        }
    }
}