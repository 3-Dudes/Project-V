import greenfoot.*;
import java.util.*;
public class Rocket extends Weapon {
    private Gru g;
    private boolean movingRight;
    private static GreenfootImage explosion;
    private int explosionTime;
    private boolean hasExploded;
    private int startX;
    private int startY;
    public Rocket(boolean movingRight) {
        super(2, 2);
        this.movingRight = movingRight;
        getLeftImage().rotate(270);
        GreenfootImage tempRight = new GreenfootImage(getLeftImage());
        tempRight.mirrorHorizontally();
        this.setLeftImage(getLeftImage());
        this.setRightImage(tempRight);
        explosion = new GreenfootImage("explosion_rocket.png");
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        startX = this.getX();
        startY = this.getY();
        w.setPaintOrder(Weapon.class, Player.class);
    }
    public void act() {
        setDamage(100);
        detectCollision("Gru", getDamage());
        if(this.getImage() != explosion) {
            if(movingRight) {
                this.setImage(getRightImage());
                this.setLocation(this.getX() + 10, this.getY());
            } 
            else {
                this.setImage(getLeftImage());
                this.setLocation(this.getX() - 10, this.getY());
            }
            if(this.isAtEdge()) {
                this.setImage(explosion);
                hasExploded = true;
            }
        }
        if(hasExploded) {
            explosionTime++;
            if(explosionTime >= 10) {
                getWorld().removeObject(this);
                explosionTime = 0;
            }
        }
    }
    @Override
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            Player player = (Player) 
                this.getOneIntersectingObject(Player.class);
            if(player != null && !(player instanceof Gru) 
                && !intersects) {
                if(movingRight && player.getX() <= this.getX() 
                    && startX <= player.getX() || !movingRight 
                    && player.getX() >= this.getX() && startX >= player.getX()) {
                    player.decreaseHealth(100);
                    this.setImage(explosion);
                    hasExploded = true;
                    intersects = true;    
                }
            }
        }
    }
}