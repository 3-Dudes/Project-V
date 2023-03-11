import greenfoot.*;
import java.util.*;
public abstract class Player extends Actor {
    protected boolean cPressed;
    protected boolean qPressed;
    protected boolean ePressed;
    protected boolean xPressed;
    
    private boolean pastHalfway;
    private boolean isFacingRight;
    private boolean isFacingLeft;
    
    private Shield shield;
    
    protected Ability c;
    protected Ability q;
    protected Ability e;
    protected Ability x;
    
    protected List<Ability> abilities;
    
    protected int health;
    
    public Player() { 
        cPressed = false;
        qPressed = false;
        ePressed = false;
        xPressed = false;
        pastHalfway = false;
        isFacingRight = true;
        shield = new Shield();
    }
    
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void decreaseHealth(int damage) {
        health -= damage;
    }
    
    public boolean isDead() {
        return health <= 0;
    }
    
    public void act() {
        move();
        checkEdges();
        if(this.getX() >= 600) {
            pastHalfway = true;
        }
        if(this.getX() < 600) {
            pastHalfway = false;
        }
        
        if(pastHalfway) {
            if(isFacingRight) {
                this.getImage().mirrorHorizontally();
                isFacingRight = false;
            }
        }
        else {
            if(!isFacingRight) {
                this.getImage().mirrorHorizontally();
                isFacingRight = true;
            }
        }
        
        if(Greenfoot.isKeyDown("C") && !cPressed) {
            cPressed = true;
            c();
        }
        if(!Greenfoot.isKeyDown("C") && cPressed) {
            cPressed = false;
        }
        
        if(Greenfoot.isKeyDown("Q") && !qPressed) {
            qPressed = true;
            q();
        }
        if(!Greenfoot.isKeyDown("Q") && qPressed) {
            qPressed = false;
        }        
        
        if(Greenfoot.isKeyDown("E") && !ePressed) {
            ePressed = true;
        }
        if(!Greenfoot.isKeyDown("E") && ePressed) {
            ePressed = false;
        }
        
        if(Greenfoot.isKeyDown("X") && !xPressed) {
            xPressed = true;
            x();
        }
        if(!Greenfoot.isKeyDown("X") && xPressed) {
            xPressed = false;
        }
        
        if(Greenfoot.isKeyDown("M")) {
            getWorld().addObject(shield, this.getX(), this.getY());
        }
        else {
            getWorld().removeObject(shield);
        }
    }
    public void checkEdges() {
        if(this.isAtEdge()) {
            if(this.getX() == 0) {
                this.setLocation(getWorld().getWidth() - 1, getY());
            }
            else if(this.getX() == getWorld().getWidth() - 1) {
                this.setLocation(0, getY());
            }
        }
    }
    public void move() {
        if(Greenfoot.isKeyDown("A")) {
            this.setLocation(this.getX() - 5, this.getY());
        }
        if(Greenfoot.isKeyDown("D")) {
            this.setLocation(this.getX() + 5, this.getY());
        }
    }
    
    public abstract void reload();
    public abstract void singleFire();
    public abstract void burstFire();
    public abstract void c();
    public abstract void q();
    public abstract void e();
    public abstract void x();
    
    protected void checkAbilities() {
        if(q.abilityReady()) {
            getWorld().getBackground().drawImage(q.getImage(), this.getX() - 50, this.getY() - 535);
            if(qPressed) {
                q.getImage().clear();
                q();
                q.setCharge(q.getCooldown() - 1);    
            }
        }
        int qCharge = q.getCharge();
        if(qCharge < q.getCooldown()) {
            qCharge--;
            q.setCharge(qCharge);
        }
        if(q.getCharge() == 0) {
            qPressed = false;
            q.setCharge(q.getCooldown());
        }
        
        if(e.abilityReady()) {
            getWorld().getBackground().drawImage(e.getImage(), this.getX(), this.getY() - 535);
            if(ePressed) {
                e();
                e.setCharge(e.getCooldown() - 1);    
            }
        }
        else {
            
        }
        int eCharge = e.getCharge();
        if(eCharge < e.getCooldown()) {
            eCharge--;
            e.setCharge(eCharge);
        }
        if(e.getCharge() == 0) {
            ePressed = false;
            e.setCharge(e.getCooldown());
        }
    }
    public static void clearAt(int x, int y) {
        
    }
}