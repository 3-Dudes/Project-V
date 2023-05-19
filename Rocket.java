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
    public boolean exists() {
        return getWorld() != null;
    }
    public boolean hasExploded() {
        return hasExploded;
    }
    @Override
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            Player p = (Player) this.getOneIntersectingObject(Player.class);
            if(p != null && !intersects && !(p instanceof Gru)) {
                if(this.getX() <= p.getX() + 20 && this.getX() >= p.getX() - 20) {   
                    p.decreaseHealth(100);
                    intersects = true;
                    hasExploded = true;
                    this.setImage(explosion);    
                }
            }
        }
    }
}