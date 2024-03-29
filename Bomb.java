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
    public void reset(int x, int y) {
        this.setImage("bomb.png");
        this.setLocation(x, y);
    }
    public void act() {
        if(onHit) {
            timer++;
            this.setImage(explosion);
        }
        else {
            this.setLocation(this.getX(), this.getY() + 10);
        }
        if(this.getY() + getImage().getHeight() / 2 >= getWorld().getHeight()) {
            onHit = true;
        }
        if(timer == 50) {
            getWorld().removeObject(this);
            timer = 0;
        }
        detectCollision("Vector", 25);
    }
    @Override
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            List<Player> players = getObjectsInRange(getImage().getHeight() / 2, Player.class);
            for(Player player : players) {
                if(!player.getClass().getName().equals(name) && !intersects) {
                    onHit = true;
                    this.setImage(explosion);
                    player.decreaseHealth(damage);
                    intersects = true;
                }
            }
        }
    }
}