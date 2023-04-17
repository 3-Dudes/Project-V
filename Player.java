import greenfoot.*;
import java.util.*;
public abstract class Player extends Actor {
    private boolean cPressed;
    private boolean qPressed;
    private boolean ePressed;
    private boolean xPressed;
    
    private boolean isFacingRight;
    private boolean isFacingLeft;
    
    private Shield shield;
    
    protected Ability c;
    protected Ability q;
    protected Ability e;
    protected Ability x;
    protected List<Ability> abilities;
    
    protected boolean pastHalfway;
    
    private HealthBar hp;
    
    protected int health;
    protected int hitpoints;
    
    protected GreenfootImage right;
    protected GreenfootImage left;
    
    private String name;
    public Player(String name, int factor) { 
        cPressed = false;
        qPressed = false;
        ePressed = false;
        xPressed = false;
        isFacingRight = true;
        this.name = name;
        hp = new HealthBar(name);
        shield = new Shield();
        abilities = new ArrayList<Ability>();
        abilities.add(c);
        abilities.add(q);
        abilities.add(e);
        
        
        right = this.getImage();
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
        right.scale(right.getWidth() / factor, right.getHeight() / factor);
        left.scale(left.getWidth() / factor, left.getHeight() / factor);
    }
    
    public int getHealth() {
        return health;
    }
    public void decreaseHealth(int damage) {
        health -= damage;
        
        GreenfootImage img = hp.getImage();
        
        double percentage = (double) health / hitpoints;
        int width = (int) (percentage * img.getWidth());
        
        img.setColor(Color.RED);
        img.fillRect(0, 0, img.getWidth(), img.getHeight());
        img.setColor(Color.GREEN);
        img.fillRect(0, 0, width, img.getHeight());
        hp.drawHeader();
        hp.setImage(img);
    }
    
    @Override
    public void addedToWorld(World world) {
        checkPosition();
    }
    
    public HealthBar getHealthBar() {
        return hp;
    }
    
    public boolean isDead() {
        return health <= 0;
    }
    
    public void act() {
        move();
        checkEdges();
        checkPosition();
        
        if(Greenfoot.isKeyDown("C") && !cPressed) {
            cPressed = true;
        }
        if(!Greenfoot.isKeyDown("C") && cPressed) {
            cPressed = false;
        }
        
        if(Greenfoot.isKeyDown("Q") && !qPressed) {
            qPressed = true;
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
    private void checkEdges() {
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
    protected void checkAbilities() {
        if(q.abilityReady()) {
            if(qPressed) {
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
            if(ePressed) {
                e();
                e.setCharge(e.getCooldown() - 1);    
            }
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
    private void checkPosition() {
        if(this.getX() >= 600) {
            pastHalfway = true;
        }
        else {
            pastHalfway = false;
        }
        if(pastHalfway) {
            if(isFacingRight) {
                this.setImage(left);
                isFacingRight = false;
            }
        }
        else {
            if(!isFacingRight) {
                this.setImage(right);
                isFacingRight = true;
            }
        }
    }
    public abstract void reload();
    public abstract void singleFire();
    public abstract void burstFire();
    public abstract void c();
    public abstract void q();
    public abstract void e();
    public abstract void x();
}