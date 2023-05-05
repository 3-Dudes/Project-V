import greenfoot.*;
import java.util.*;
public abstract class Weapon extends Actor {
    private boolean intersects;
    protected Player p;
    private int spaceX;
    private int spaceY;
    private int damage;
    private GreenfootImage left;
    private GreenfootImage right;
    private GreenfootImage leftUnscaled;
    private GreenfootImage rightUnscaled;
    public Weapon(Player p, int spaceX, int spaceY, Integer factor) {
        this.intersects = false;
        this.p = p;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
        this.damage = 0;
        right = getImage();
        rightUnscaled = new GreenfootImage(right);
        leftUnscaled = new GreenfootImage(rightUnscaled);
        leftUnscaled.mirrorHorizontally();
        if(factor != null) {
            right.scale(right.getWidth() / factor, right.getWidth() / factor);    
        }
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
    }
    public Weapon(Integer factor) {
        this.intersects = false;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
        this.damage = 0;
        right = getImage();
        rightUnscaled = new GreenfootImage(right);
        leftUnscaled = new GreenfootImage(rightUnscaled);
        leftUnscaled.mirrorHorizontally();
        if(factor != null) {
            right.scale(right.getWidth() / factor, right.getWidth() / factor);    
        }
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void act() {
        if(p != null) {
            if(!p.facingRight()) {
                this.setLocation(p.getX() - spaceX, p.getY() - spaceY);
                this.setImage(left);
            }   
            else {
                this.setLocation(p.getX() + spaceX, p.getY() - spaceY);
                this.setImage(right);
            }
            if(this.isAtEdge()) {
                if(this.getX() == 0) {
                    p.setLocation(getWorld().getWidth() - 1, p.getY());
                }
                else if(this.getX() == getWorld().getWidth() - 1) {
                    p.setLocation(0, p.getY());
                }
            }
        }
    }
    public GreenfootImage getLeftUnscaledImage() {
        return leftUnscaled;
    }
    public GreenfootImage getRightUnscaledImage() {
        return rightUnscaled;
    }
    public GreenfootImage getLeftImage() {
        return left;
    }
    public GreenfootImage getRightImage() {
        return right;
    }
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            Player player = (Player) this.getOneIntersectingObject(Player.class);
            if(player != null && !(player.getClass().getName().equals(name)) && !intersects) {
                player.decreaseHealth(damage);
                intersects = true;
            }
        }
    }
}