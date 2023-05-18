import greenfoot.*;
import java.util.*;
public abstract class Weapon extends Actor {
    protected boolean intersects;
    protected Player p;
    private int spaceX;
    private int spaceY;
    private int damage;
    private boolean isFacingRight;
    private GreenfootImage left;
    private GreenfootImage right;
    private GreenfootImage leftUnscaled;
    private GreenfootImage rightUnscaled;
    public Weapon(Player p, int spaceX, int spaceY, boolean isFacingRight, 
        Integer widthFactor, Integer lengthFactor) {
        this(widthFactor, lengthFactor);
        this.intersects = false;
        this.p = p;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
        this.isFacingRight = isFacingRight;
    }
    public Weapon(Integer widthFactor, Integer lengthFactor) {
        this.intersects = false;
        if(isFacingRight) {
            right = getImage();
            if(widthFactor != null && lengthFactor != null) {
                right.scale(right.getWidth() / widthFactor, 
                    right.getWidth() / lengthFactor);    
            }
            left = new GreenfootImage(right);
            left.mirrorHorizontally();
        }
        else {
            left = getImage();
            if(widthFactor != null && lengthFactor != null) {
                left.scale(left.getWidth() / widthFactor, 
                    left.getWidth() / lengthFactor);    
            }
            right = new GreenfootImage(left);
            right.mirrorHorizontally();
        }
        rightUnscaled = new GreenfootImage(right);
        leftUnscaled = new GreenfootImage(rightUnscaled);
        leftUnscaled.mirrorHorizontally();
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
    public void setRightImage(GreenfootImage right) {
        this.right = right;
    }
    public void setLeftImage(GreenfootImage left) {
        this.left = left;
    }
    public boolean facingRight() {
        return isFacingRight;
    }
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            Player player = (Player) 
                getOneObjectAtOffset(0, 0, Player.class);
            if(player != null && !(player.getClass().getName().equals(name)) 
                && !intersects) {
                player.decreaseHealth(damage);
                intersects = true;
            }
        }
    }
}