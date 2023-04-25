import greenfoot.*;
import java.util.*;
public abstract class Player extends Actor {
    private boolean cPressed;
    private boolean qPressed;
    private boolean ePressed;
    private boolean xPressed;
    
    private int playerScore;
    
    private boolean isFacingRight;
    protected boolean canMove;
    protected boolean canCast;
    
    private Shield shield;
    
    protected Ability c;
    protected Ability q;
    protected Ability e;
    protected Ability x;
    protected List<Ability> abilities;
    
    private HealthBar hp;
    
    protected int health;
    protected int hitpoints;
    
    protected boolean pastHalfway;
    
    private GreenfootImage right;
    private GreenfootImage left;
    private int factor;
    
    private int timeDisabled;
    
    private String name;    
    public Player(String name, int factor) { 
        cPressed = false;
        qPressed = false;
        ePressed = false;
        xPressed = false;
        isFacingRight = true;
        pastHalfway = false;
        this.name = name;
        this.playerScore = 0;
        hp = new HealthBar(name);
        shield = new Shield();
        abilities = new ArrayList<Ability>();
        abilities.add(c);
        abilities.add(q);
        abilities.add(e);
        this.factor = factor;
        this.canMove = true;
        this.canCast = true;
        timeDisabled = 0;
        
        right = this.getImage();
        scaleImage(right);
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
    }
    
    public boolean facingRight() {
        return isFacingRight;
    }
    public int getHealth() {
        return health;
    }
    public final void decreaseHealth(int damage) {
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
    public final void increaseHealth(int damage) {
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
        updatePosition();
        world.addObject(this.getHealthBar(), this.getX(), 50);
    }
    
    public HealthBar getHealthBar() {
        return hp;
    }
    
    public void setRightImage(GreenfootImage right) {
        this.right = right;
    }
    public void setLeftImage(GreenfootImage left) {
        this.left = left;
    }
    
    public boolean isDead() {
        if(health <= 0) {
            canMove = false;
            return true;
        }
        return false;
    }
    
    public Ability getCAbility() {
        return c;
    }
    public Ability getQAbility() {
        return q;
    }
    public Ability getEAbility() {
        return e;
    }
    public Ability getUltimateAbility() {
        return x;
    }
    
    public void act() {
        if(!this.isDead()) {
            if(getTimeDisabled() == 100 && !canMove && this.getRotation() == 90) {
                this.setRotation(0);
                canMove = true;
                setTimeDisabled(0);
            }
            if(canMove) {
                move();
                checkEdges();    
            }
            if(canCast) {
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
            if(this instanceof ElMacho) updateCast(c);
            updateCast(q);
            updateCast(e);
        }
        if(!canMove) {
            timeDisabled += 1;
        }
    }
    
    public void scaleImage(GreenfootImage img) {
        img.scale(img.getWidth() / factor, img.getHeight() / factor);
    }
    public int getTimeDisabled() {
        return timeDisabled;
    }
    public void setTimeDisabled(int timeDisabled) {
        this.timeDisabled = timeDisabled;
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
    public final void move() {
        if(Greenfoot.isKeyDown("A")) {
            this.setLocation(this.getX() - 5, this.getY());
            this.setImage(left);
            isFacingRight = false;
        }
        if(Greenfoot.isKeyDown("D")) {
            this.setLocation(this.getX() + 5, this.getY());
            this.setImage(right);
            isFacingRight = true;
        }
    }
    protected final void checkAbilities() {
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
        
        if(c.abilityReady()) {
            if(cPressed) {
                c();
                c.setCharge(c.getCooldown() - 1);    
            }
        }
        int cCharge = c.getCharge();
        if(cCharge < c.getCooldown()) {
            cCharge--;
            c.setCharge(cCharge);
        }
        if(c.getCharge() == 0) {
            cPressed = false;
            c.setCharge(c.getCooldown());
        }
    }
    private void updatePosition() {
        if(this.getX() >= 600) {
            pastHalfway = true;
        }
        else {
            pastHalfway = false;
        }
        if(pastHalfway) {
            this.setImage(left);
            isFacingRight = false;
        }    
        else {
            this.setImage(right);
            isFacingRight = true;
        }
    }
    public int getPlayerScore() {
        return playerScore;
    }
    public GreenfootImage getRightImage() {
        return right;
    }
    public GreenfootImage getLeftImage() {
        return left;
    }
    private void updateCast(Ability ab) {
        if(ab.isFinished()) {
            canCast = true;
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