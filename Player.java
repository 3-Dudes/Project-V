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
    
    protected Ability c;
    protected Ability q;
    protected Ability e;
    protected Ability x;
    
    private HealthBar hp;
    
    protected int health;
    protected int hitpoints;
    
    protected boolean pastHalfway;
    
    private GreenfootImage[] rightFrames;
    private GreenfootImage[] leftFrames;
    private GreenfootImage right;
    private GreenfootImage left;
    private int factor;
    private int currentFrame;
    private int frameDelay;
    private boolean isMoving;
    private int timeDisabled;
    
    private String name;    
    private String nickname;
    public Player(String name, int factor) { 
        cPressed = false;
        qPressed = false;
        ePressed = false;
        xPressed = false;
        isFacingRight = true;
        pastHalfway = false;
        this.name = name;
        this.nickname = nickname;
        this.playerScore = 0;
        hp = new HealthBar(name);
        this.factor = factor;
        this.canMove = true;
        this.canCast = true;
        timeDisabled = 0;
        right = getImage();
        right.scale(right.getWidth() / factor, right.getHeight() / factor);
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
        if(facingRight()) {
            setImage(right);
        }
        else {
            setImage(left);
        }
    }
    public Player(String name, int factor, String nickname) {
        this(name, factor);
        this.rightFrames = new GreenfootImage[21];
        this.leftFrames = new GreenfootImage[21];
        for(int i = 0; i < rightFrames.length; i++) {
            rightFrames[i] = new GreenfootImage(nickname + (i + 1) + ".png");
            rightFrames[i].scale(rightFrames[i].getWidth() / factor, 
                rightFrames[i].getHeight() / factor);
        }
        for(int i = 0; i < leftFrames.length; i++) {
            leftFrames[i] = new GreenfootImage(rightFrames[i]);
            leftFrames[i].mirrorHorizontally();
        }
        frameDelay = 8;
        currentFrame = 0;
        isMoving = false;
        right = new GreenfootImage(rightFrames[0]);
        left = new GreenfootImage(leftFrames[0]);
        if(facingRight()) {
            setImage(right);
        }
        else {
            setImage(left);
        }
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
                    if(c == null) {
                        c();
                    }
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
                    if(x == null) {
                        x();    
                    }
                }
                if(!Greenfoot.isKeyDown("X") && xPressed) {
                    xPressed = false;
                }
            }
        }
        if(!canMove) {
            timeDisabled += 1;
        }
        updateAbility(c);
        updateAbility(q);
        updateAbility(e);
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
    
    public final void checkEdges() {
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
            isFacingRight = false;
            isMoving = true;
        }
        if(Greenfoot.isKeyDown("D")) {
            this.setLocation(this.getX() + 5, this.getY());
            isFacingRight = true;
            isMoving = true;
        }
        if(!Greenfoot.isKeyDown("A") && !Greenfoot.isKeyDown("D")) {
            isMoving = false;
        }
        if(isMoving) {
            animate();
        }
        else {
            if(facingRight()) {
                setImage(right);
            }
            else {
                setImage(left);
            }
        }
    }
    public final void animate() {
        if(isFacingRight) {
            this.setImage(rightFrames[currentFrame]);   
        }
        else {
            this.setImage(leftFrames[currentFrame]);
        }
        if(frameDelay == 0) {
            currentFrame++;    
            frameDelay = 8;
        }
        frameDelay--;
        if(currentFrame == 21) {
            currentFrame = 0;
        }
    }
    private void updateAbility(Ability ab) {
        if(ab != null && ab.isFinished()) {
            canCast = true;
        }
    }
    protected void checkAbilities() {
        if(q != null) {
            if(q.isReady()) {
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
        }
        if(e != null) {
            if(e.isReady()) {
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
        if(c != null) {
            if(c.isReady()) {
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
    public abstract void reload();
    public abstract void singleFire();
    public abstract void burstFire();
    public abstract void c();
    public abstract void q();
    public abstract void e();
    public abstract void x();
}