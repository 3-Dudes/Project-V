import greenfoot.*;
import java.util.*;
public abstract class Player extends Actor {
    protected boolean cPressed;
    protected boolean qPressed;
    protected boolean ePressed;
    protected boolean xPressed;
    protected boolean bPressed;
    protected boolean vPressed;
    protected boolean wPressed;
    protected boolean mPressed;
    protected boolean nPressed;
    protected boolean lPressed;
    protected boolean kPressed;
    protected boolean pPressed;
    protected boolean oPressed;
    protected boolean iPressed;
    protected boolean upPressed;

    private int playerScore;
    private int jumpHeight = -10;

    private boolean isFacingRight;
    protected boolean canMove;
    protected boolean canCast;
    private int startX;
    
    private Ability c;
    private Ability q;
    private Ability e;
    private UltimateAbility x;
    private Ability b;
    private Ability v;
    
    private HealthBar hp;
    
    private int health;
    private int hitpoints;
    private int vSpeed;
    private int acceleration;
    
    protected boolean pastHalfway;
    
    private GreenfootImage[] rightFrames;
    private GreenfootImage[] leftFrames;
    private GreenfootImage right;
    private GreenfootImage left;
    private int factor;
    private int currentFrame;
    private int frameDelay;
    private int frameDelayCopy;
    private boolean isMoving;
    private int timeDisabled;

    private String name;    
    private String nickname;
    public Player(String name, int factor, 
        boolean isFacingRight, int health, int hitpoints) { 
        cPressed = false;
        qPressed = false;
        ePressed = false;
        xPressed = false;
        bPressed = false;
        vPressed = false;
        this.isFacingRight = isFacingRight;
        pastHalfway = false;
        this.health = health;
        this.hitpoints = hitpoints;
        this.name = name;
        this.nickname = nickname;
        this.playerScore = 0;
        hp = new HealthBar(name);
        this.factor = factor;
        this.canMove = true;
        this.canCast = true;
        timeDisabled = 0;
        acceleration = 1;
        right = getImage();
        right.scale(right.getWidth() / factor, right.getHeight() / factor);
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
        vSpeed = 0;
        if(facingRight()) {
            this.setImage(right);
        }
        else {
            this.setImage(left);
        }
    }
    public Player(String name, int factor, boolean isFacingRight, 
        int health, int hitpoints, String nickname, int frameDelay) {
        this(name, factor, isFacingRight, health, hitpoints);
        this.rightFrames = new GreenfootImage[21];
        this.leftFrames = new GreenfootImage[21];
        for(int i = 0; i < rightFrames.length; i++) {
            if(facingRight()) {
                rightFrames[i] = new GreenfootImage(nickname + (i + 1) + ".png");
                rightFrames[i].scale(rightFrames[i].getWidth() / factor, 
                    rightFrames[i].getHeight() / factor); 
                leftFrames[i] = new GreenfootImage(rightFrames[i]);
                leftFrames[i].mirrorHorizontally();
            }
            else {
                leftFrames[i] = new GreenfootImage(nickname + (i + 1) + ".png");
                leftFrames[i].scale(leftFrames[i].getWidth() / factor, 
                    leftFrames[i].getHeight() / factor); 
                rightFrames[i] = new GreenfootImage(leftFrames[i]);
                rightFrames[i].mirrorHorizontally();
            }
        }
        this.frameDelay = frameDelay;
        frameDelayCopy = frameDelay;
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
    public Player(String name, int factor, 
        boolean isFacingRight, int health, int hitpoints, 
        String nickname, int frameDelay, Ability c, Ability q, Ability e, 
        UltimateAbility x, Ability b, Ability v) {
        this(name, factor, isFacingRight, health, hitpoints, nickname, frameDelay);
        this.c = c;
        this.q = q;
        this.e = e;
        this.x = x;
        this.b = b;
        this.v = v;
    }
    public void setFrameDelay(int frameDelay) {
        this.frameDelay = frameDelay;
    }
    public boolean facingRight() {
        return isFacingRight;
    }

    public int getHealth() {
        return health;
    }
    public void setRightFrames(GreenfootImage[] rightFrames) {
        this.rightFrames = rightFrames;
    }
    public void setLeftFrames(GreenfootImage[] leftFrames) {
        this.leftFrames = leftFrames;
    }
    public GreenfootImage[] getLeftFrames() {
        return leftFrames;
    }
    public GreenfootImage[] getRightFrames() {
        return rightFrames;
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
    public void setFacingRight(boolean isFacingRight){
        this.isFacingRight = isFacingRight;
    }
    @Override
    public void addedToWorld(World world) {
        updatePosition();
        startX = this.getX();
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
    public UltimateAbility getUltimateAbility() {
        return x;
    }
    public Ability getBAbility() {
        return b;
    }
    public Ability getVAbility() {
        return v;
    }
    
    public void setCAbility(Ability c) {
        this.c = c;
    }
    public void setQAbility(Ability q) {
        this.q = q;
    }
    public void setEAbility(Ability e) {
        this.e = e;
    }
    public void setXAbility(UltimateAbility x) {
        this.x = x;
    }
    public void setBAbility(Ability b) {
        this.b = b;
    }
    public void setVAbility(Ability v) {
        this.v = v;
    }
    
    @Override
    public boolean intersects(Actor a) {
        return super.intersects(a);
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
                fall();
                checkEdges();    
                if(startX == 200) {
                    if(Greenfoot.isKeyDown("W") && !wPressed && getY() == 550) {
                        jump();
                        wPressed = true;
                    }
                    if(!Greenfoot.isKeyDown("W") && wPressed) {
                        wPressed = false;
                    }    
                }
                if(startX == 1000) {
                    if(Greenfoot.isKeyDown("UP") && !upPressed && getY() == 550) {
                        jump();
                        upPressed = true;
                    }
                    if(!Greenfoot.isKeyDown("UP") && upPressed) {
                        upPressed = false;
                    }    
                }
            }
            if(canCast) {
                castMoves();
            }
        }
        if(!canMove) {
            timeDisabled += 1;
        }
        updateAbility(c);
        updateAbility(q);
        updateAbility(e);
        updateAbility(b);
        updateUltimateAbility(x);
        checkAbilities();
    }
    
    public final void castMoves() {
        castC();
        castQ();
        castE();
        castX();
        castB();
        castV();
    }
    
    protected void castC() {
        if(startX == 200) {
            if(Greenfoot.isKeyDown("C") && !cPressed) {
                cPressed = true;
                if(c == null) {
                    c();
                }
            }
            if(!Greenfoot.isKeyDown("C") && cPressed) {
                cPressed = false;
            }
        }
        if(startX == 1000) {
            if(Greenfoot.isKeyDown("L") && !lPressed) {
                lPressed = true;
                if(c == null) {
                    c();
                }
                else {
                    if(c.isReady()) {
                        c();
                    }
                }
            }
            if(!Greenfoot.isKeyDown("L") && lPressed) {
                lPressed = false;
            }
        }
    }
    protected void castQ() {
        if(startX == 200) {
            if(Greenfoot.isKeyDown("Q") && !qPressed) {
                if(q == null) {
                    q();
                }
                qPressed = true;
            }
            if(!Greenfoot.isKeyDown("Q") && qPressed) {
                qPressed = false;
            }
        }
        if(startX == 1000) {
            if(Greenfoot.isKeyDown("O") && !oPressed) {
                if(q == null) {
                    q();
                }
                qPressed = true;
            }
            if(!Greenfoot.isKeyDown("O") && oPressed) {
                qPressed = false;
            }
        }
    }
    protected void castE() {
        if(startX == 200) {
            if(Greenfoot.isKeyDown("E") && !ePressed) {        
                if(e == null) {
                    e();
                }
                ePressed = true;
            }
            if(!Greenfoot.isKeyDown("E") && ePressed) {
                ePressed = false;
            }
        }
        if(startX == 1000) {
            if(Greenfoot.isKeyDown("P") && !pPressed) {        
                if(e == null) {
                    e();
                }
                else {
                    if(e.isReady()) {
                        e();
                    }
                }
                pPressed = true;
            }
            if(!Greenfoot.isKeyDown("P") && pPressed) {
                pPressed = false;
            }
        }
    }
    protected void castX() {
        if(startX == 200) {
            if(Greenfoot.isKeyDown("X") && !xPressed) {
                xPressed = true;
                x();
            }
            if(!Greenfoot.isKeyDown("X") && xPressed) {
                xPressed = false;
            }    
        }
        if(startX == 1000) {
            if(Greenfoot.isKeyDown("K") && !kPressed) {        
                kPressed = true;
                x();
            }
            if(!Greenfoot.isKeyDown("K") && kPressed) {
                kPressed = false;
            }    
        }
    }
    protected void castB() {
        if(startX == 200) {
            if(Greenfoot.isKeyDown("B") && !bPressed) {
                bPressed = true;
                if(b == null) {
                    burstFire();    
                }
            }
            if(!Greenfoot.isKeyDown("B") && bPressed) {
                bPressed = false;
            }    
        }
        if(startX == 1000) {
            if(Greenfoot.isKeyDown("M") && !mPressed) {
                mPressed = true;
                if(b == null) {
                    burstFire();    
                }
            }
            if(!Greenfoot.isKeyDown("M") && mPressed) {
                mPressed = false;
            }    
        }
    }
    protected void castV() {
        if(startX == 200) {
            if(Greenfoot.isKeyDown("V") && !vPressed) {
                 vPressed = true;
                 if(v == null) {
                     singleFire();    
                 }
            }
            if(!Greenfoot.isKeyDown("V") && vPressed) {
                 vPressed = false;
            }
        }
        if(startX == 1000) {
            if(Greenfoot.isKeyDown("N") && !nPressed) {
                 nPressed = true;
                 if(v == null) {
                     singleFire();    
                 }
            }
            if(!Greenfoot.isKeyDown("N") && nPressed) {
                 vPressed = false;
            }    
        }
    }

    public final void jump() {
        vSpeed = -15;
        //this.setLocation(this.getX(), this.getY()- 150);

    }

    public void fall() {
        setLocation(getX(), getY() + vSpeed);
        if(getY() >= 550) {
            vSpeed = 0;
            setLocation(getX(), 550);
        }   
        else {
            vSpeed = vSpeed + acceleration;
        }
    }
    public final void checkPlatformDetection() {
        Platform p = (Platform) this.getOneObjectAtOffset(0, getImage().getHeight() / 2, Platform.class);
        if(p != null) {
            this.setLocation(p.getX(), p.getY());
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
        if(Greenfoot.isKeyDown("A") && startX == 200) {
            this.setLocation(this.getX() - 5, this.getY());
            isFacingRight = false;
            isMoving = true;
            this.setImage(right);
        }
        if(Greenfoot.isKeyDown("D") && startX == 200) {
            this.setLocation(this.getX() + 5, this.getY());
            isFacingRight = true;
            isMoving = true;
            this.setImage(left);
        }
        if(Greenfoot.isKeyDown("LEFT") && startX == 1000) {
            this.setLocation(this.getX() - 5, this.getY());
            isFacingRight = false;
            isMoving = true;
            this.setImage(right);
        }
        if(Greenfoot.isKeyDown("RIGHT") && startX == 1000) {
            this.setLocation(this.getX() + 5, this.getY());
            isFacingRight = true;
            isMoving = true;
            this.setImage(left);
        }
        if((!Greenfoot.isKeyDown("A") && !Greenfoot.isKeyDown("D") ||
            Greenfoot.isKeyDown("A") && Greenfoot.isKeyDown("D")) && startX == 200) {
            isMoving = false;
        }
        if((!Greenfoot.isKeyDown("LEFT") && !Greenfoot.isKeyDown("RIGHT") ||
            Greenfoot.isKeyDown("LEFT") && Greenfoot.isKeyDown("RIGHT")) && startX == 1000) {
            isMoving = false;
        }
        if(isMoving) {
            animate();
        }
        else {
            if(facingRight()) {
                this.setImage(right);
            }
            else {
                this.setImage(left);
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
            frameDelay = frameDelayCopy;
        }
        frameDelay--;
        if(currentFrame == 21) {
            currentFrame = 0;
        }

    }

    private void updateAbility(Ability ab) {
        if(ab != null && ab.isFinished()) {
            canCast = true;
            canMove = true;
        }
    }
    private void updateUltimateAbility(UltimateAbility ult) {
        if(ult != null && ult.isFinished()) {
            canCast = true;
            canMove = true;
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
        if(b != null) {
            if(b.isReady()) {
                if(bPressed) {
                    burstFire();
                    b.setCharge(b.getCooldown() - 1);    
                }
            }
            int bCharge = b.getCharge();
            if(bCharge < b.getCooldown()) {
                bCharge--;
                b.setCharge(bCharge);
            }
            if(b.getCharge() == 0) {
                bPressed = false;
                b.setCharge(b.getCooldown());
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
    public void reload() {
        //empty method body; not every class needs to override it
    }
    public abstract void singleFire();

    public abstract void burstFire();

    public abstract void c();

    public abstract void q();

    public abstract void e();

    public abstract void x();
    public boolean isIntersecting(Actor a) {
        return this.intersects(a);
    }
}