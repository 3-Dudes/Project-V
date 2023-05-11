import greenfoot.*;
import java.util.*;
public class Bomb extends Weapon {
    private GreenfootImage explosion;
    private int timer;
    private boolean onHit;
    public Bomb() {
        super(6, 6);
        timer = 0;
        onHit = false;
        explosion = new GreenfootImage("bomb_explode.png");
        explosion.scale(explosion.getWidth() / 3, explosion.getHeight() / 3);
    }
    public void act() {
        if(onHit) {
            timer++;
        }
        else {
            this.setLocation(this.getX(), this.getY() + 10);
        }
        Player p = (Player) getOneIntersectingObject(Player.class);
        if((p != null || this.getY() + getImage().getHeight() / 2 >= getWorld().getHeight()) && this.getImage() != explosion) {
            this.setImage(explosion);
            onHit = true;
        }
        if(timer == 100) {
            getWorld().removeObject(this);
        }
        detectCollision("Vector", 25);
    }
    @Override
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            List<Player> players = getObjectsInRange(getImage().getWidth() / 2, Player.class);
            for(Player player : players) {
                if(!player.getClass().getName().equals(name) && !intersects) {
                    player.decreaseHealth(damage);
                    intersects = true;
                }
            }
        }
    }
}