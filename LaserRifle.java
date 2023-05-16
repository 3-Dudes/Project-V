import greenfoot.*;
import java.util.List;
public class LaserRifle extends Weapon {
    private Gru g;
    private int spaceX;
    private int spaceY;
    private RedLaser laser;
    public LaserRifle(Gru g, int spaceX, int spaceY) {
        super(g, spaceX, spaceY, false, 10, 10);
        this.g = g;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
        laser = new RedLaser();
    }
    public boolean exists() {
        List<LaserRifle> laserRifles = 
            getWorld().getObjects(LaserRifle.class);
        return laserRifles.size() != 0;
    }
    @Override
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            Player player = (Player) 
                laser.getOneIntersectingObject(Player.class);
            if(player != null && !(player.getClass().getName().equals(name)) 
                && !intersects) {
                player.decreaseHealth(damage);
                intersects = true;
            }
        }
    }
}