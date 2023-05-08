import greenfoot.*;
import java.util.*;
public class ElMacho extends Player {
    private AmmoGUI ammoGui;
    private int timeToReload;
    private boolean needToReload;
    private boolean vPressed;
    private boolean bPressed;
    private boolean rPressed;
    public boolean usedUlt;
    public int ultDur;
    public static GreenfootImage eduardo;
    public boolean isEduardo;
    public static GreenfootImage elMacho;
    private GreenfootImage[] rightMachoFrames;
    private GreenfootImage[] leftMachoFrames;
    private int currentFrame;
    private boolean facingRight;
    private int frameDelay;
    private boolean isMoving;
    private Random rand;
    public ElMacho() {
        super("El Macho", 2);
        health = 700;
        hitpoints = 700;
        //ammoCount = 5;
        timeToReload = 0;

        needToReload = false;
        vPressed = false;
        bPressed = false;
        rPressed = false;
        usedUlt = false;
        isEduardo = false;
        ultDur = 0;
        rand = new Random();
        elMacho = getImage();
        eduardo = new GreenfootImage("eduardo_perez.png");
        eduardo.scale(eduardo.getWidth() / 2, eduardo.getHeight() / 2);
        
        rightMachoFrames = new GreenfootImage[21];
        for(int i = 0; i < rightMachoFrames.length; i++) {
            rightMachoFrames[i] = new GreenfootImage("macho" + (i + 1) + ".png");
            rightMachoFrames[i].scale(rightMachoFrames[i].getWidth() / 2, 
                rightMachoFrames[i].getHeight() / 2);
        }
        leftMachoFrames = new GreenfootImage[21];
        for(int i = 0; i < leftMachoFrames.length; i++) {
            leftMachoFrames[i] = new GreenfootImage(rightMachoFrames[i]);
            leftMachoFrames[i].mirrorHorizontally();
        }
        currentFrame = 0;
        frameDelay = 6;
        isMoving = false;
    }
    
    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        ammoGui = new AmmoGUI(5, 5, 
            new TortillaChip(facingRight(), this).getImage(), pastHalfway);
        changePersona();
        q = new WrestlingChamp(this);
        e = new GuacamoleTortillaChip(facingRight());
        if(pastHalfway) {
            this.setImage(getLeftImage());
            getWorld().addObject(ammoGui, 1100, 400);
        }
        else {
            this.setImage(getRightImage());
            getWorld().addObject(ammoGui, 5, 400);
        }
        reload();
    }

    public void singleFire() {
        if(ammoGui.cur > 0) {
            getWorld().addObject(
                new TortillaChip(facingRight(), this), getX(), getY());
            ammoGui.loseChip();
        }
    }

    public void burstFire() {
        if(ammoGui.cur >= 3) {
            int a = 0;
            for(int k = 1; k <= 3; k++) {
                getWorld().addObject(new TortillaChip(facingRight(), this), getX() + a, getY());
                a += 60;
            }
            for(int k = 1; k <= 3; k++) {
                ammoGui.loseChip();
            }   
        }
    }

    public void reload() {
        ammoGui.refill();
        needToReload = false;
    }    

    public void timedReload() {
        if(timeToReload == 200) {
            reload();
            timeToReload = 0;
        }
        timeToReload++;
    }

    private void changePersona() {
        GreenfootImage tempRight = new GreenfootImage(elMacho);
        GreenfootImage tempLeft = new GreenfootImage(tempRight);
        tempLeft.mirrorHorizontally();
        if(isEduardo) {
            tempLeft = new GreenfootImage(eduardo);
            tempRight = new GreenfootImage(tempLeft);
            tempRight.mirrorHorizontally();
        }
        setRightImage(tempRight);
        setLeftImage(tempLeft);
        if(facingRight()) {
            this.setImage(tempRight);
        }
        else {
            this.setImage(tempLeft);
        }
    }
    
    @Override
    public void move() {
        if(Greenfoot.isKeyDown("D")) {
            setLocation(getX() + 5, getY());
            animate();
            isMoving = true;
            facingRight = true;
        }
        else if(Greenfoot.isKeyDown("A")) {
            setLocation(getX() - 5, getY());
            animate();
            isMoving = true;
            facingRight = false;
        }
        else {
            isMoving = false;
        }
    }

    @Override
    public void act() {
        super.act();
        if(canCast) {
            if(ammoGui.cur <= 0 || Greenfoot.isKeyDown("R") && !rPressed) {
                if(Greenfoot.isKeyDown("R") && !rPressed) {
                    rPressed = true;
                }
                needToReload = true;
            }
            if(!Greenfoot.isKeyDown("R") && rPressed) {
                rPressed = false;
            }
            if(needToReload) {
                timedReload();
            }

            if(Greenfoot.isKeyDown("B") && !bPressed) {
                bPressed = true;
                if(needToReload) {
                    needToReload = false;
                }
                burstFire();
            }
            if(!Greenfoot.isKeyDown("B") && bPressed) {
                bPressed = false;
            } 

            if(Greenfoot.isKeyDown("V") && !vPressed) {
                vPressed = true;
                if(needToReload) {
                    needToReload = false;
                }
                singleFire();
            }
            if(!Greenfoot.isKeyDown("V") && vPressed) {
                vPressed = false;
            }    
        }
        if(!isMoving) {
            if(facingRight) {
                setImage(rightMachoFrames[0]);
            }
            else {
                setImage(leftMachoFrames[0]);
            }
        }
        checkAbilities();
    }    
    
    private void animate() {
        if(facingRight) {
            setImage(rightMachoFrames[currentFrame]);   
        }
        else {
            setImage(leftMachoFrames[currentFrame]);
        }
        if(frameDelay == 0) {
            currentFrame++;    
            frameDelay = 6;
        }
        frameDelay--;
        if(currentFrame == 21) {
            currentFrame = 0;
        }
    }
    
    @Override
    protected void checkAbilities() {
        super.checkAbilities();
        if(q.isReady()) {
            if(isEduardo) {
                q = new Waffle(facingRight());
            }
            else {
                q = new WrestlingChamp(this);
            }
        }
        if(e.isReady()) {
            if(isEduardo) {
                e = new Sombrero();
            }
            else {
                e = new GuacamoleTortillaChip(facingRight());
            }    
        }
    }

    public void q() {
        getWorld().addObject(q, this.getX(), this.getY());
        if(!isEduardo) {
            this.setImage((GreenfootImage) null);
            this.canMove = false;
            this.canCast = false;    
        }
    }

    public void c() {
        if(isEduardo) {
            isEduardo = false;
        }
        else {
            isEduardo = true;
        }
        changePersona();
    }   

    public void e() {
        int x = this.getX();
        int y = this.getY();
        if(isEduardo) {
            x += 125;
        }
        getWorld().addObject(e, x, y);
    }

    public void x() {
        World curWorld = getWorld();
        usedUlt = true;
        canCast = false;
        List<TortillaChip> chips = new ArrayList<TortillaChip>();
        for(int k = 1; k <= 50; k++) {
            TortillaChip tc = new TortillaChip(this);
            int randX = rand.nextInt(curWorld.getWidth());
            int randY = rand.nextInt(curWorld.getHeight());
            getWorld().addObject(tc, randX, randY);
        }
    }
}