import greenfoot.*;
import java.util.*;
public class ElMacho extends Player {
    private AmmoGUI ammoGui;
    private int timeToReload;
    private boolean needToReload;
    private boolean rPressed;
    private boolean iPressed;
    public boolean usedUlt;
    public int ultDur;
    public boolean isEduardo;
    private Random rand; 
    private GreenfootSound rain = new GreenfootSound("strongraincarroof-44050.mp3");
    private static GreenfootImage[] machoLeftFrames;
    private static GreenfootImage[] machoRightFrames;
    private static GreenfootImage[] eduardoLeftFrames;
    private static GreenfootImage[] eduardoRightFrames;
    public ElMacho() {
        super("El Macho", 2, true, 700, 700, "macho", 6, null,
            new WrestlingChamp(), new GuacamoleTortillaChip(), 
            null, null, null);
        timeToReload = 0;
        setQAbility(new WrestlingChamp(this));
        setEAbility(new GuacamoleTortillaChip(facingRight()));
        needToReload = false;
        rPressed = false;
        usedUlt = false;
        isEduardo = false;
        ultDur = 0;
        rand = new Random();
        machoLeftFrames = getLeftFrames();
        machoRightFrames = getRightFrames();
        eduardoLeftFrames = new GreenfootImage[21];
        eduardoRightFrames = new GreenfootImage[21];
        for(int i = 0; i < eduardoLeftFrames.length; i++) {
            eduardoRightFrames[i] 
                = new GreenfootImage("eduardo" + (i + 1) + ".png");
            eduardoRightFrames[i].scale(eduardoRightFrames[i].getWidth() / 3, 
                eduardoRightFrames[i].getHeight() / 3);
        }
        for(int i = 0; i < eduardoLeftFrames.length; i++) {
            eduardoLeftFrames[i] = new GreenfootImage(eduardoRightFrames[i]);
            eduardoLeftFrames[i].mirrorHorizontally();
        }
        changePersona();
    }
    
    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        ammoGui = new AmmoGUI(5, 5, new TortillaChip(facingRight(), this).getImage(), 
            pastHalfway, 50, 1, 1);
        if(pastHalfway) {
            this.setImage(getLeftImage());
            getWorld().addObject(ammoGui, 1150, 400);
        }
        else {
            this.setImage(getRightImage());
            getWorld().addObject(ammoGui, 45, 400);
        }
        reload();
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
        if(isEduardo) {
            setLeftFrames(eduardoLeftFrames);
            setRightFrames(eduardoRightFrames);
            setLeftImage(eduardoLeftFrames[1]);
            setRightImage(eduardoRightFrames[1]);
            setFrameDelay(5);
        }
        else {
            setLeftFrames(machoLeftFrames);
            setRightFrames(machoRightFrames);
            setLeftImage(machoLeftFrames[1]);
            setRightImage(machoRightFrames[1]);
            setFrameDelay(5);
        }
        if(facingRight()) {
            this.setImage(getRightImage());
        }
        else {
            this.setImage(getLeftImage());
        }
    }

    @Override
    public void act() {
        super.act();
        if(canCast) {
            castMoves();    
            if(ammoGui.cur <= 0 || Greenfoot.isKeyDown("R") 
                && !rPressed) {
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
        }
        checkAbilities();
    }    
    
    @Override
    protected void castB() {
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
    }
    @Override
    protected void castV() {
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
    
    public void c() {
        if(isEduardo) {
            isEduardo = false;
        }
        else {
            isEduardo = true;
        }
        canCast = false;
        changePersona();
        canCast = true;
    } 
    public void q() {
        if(isEduardo) {
            setQAbility(new Waffle(facingRight()));
        }
        else {
            setQAbility(new WrestlingChamp(this));
        }
        getWorld().addObject(getQAbility(), this.getX(), this.getY());
        if(!isEduardo) {
            this.setImage((GreenfootImage) null);
            this.canMove = false;
            this.canCast = false;    
        }
    }  
    public void e() {
        int x = this.getX();
        int y = this.getY();
        if(isEduardo) {
            setEAbility(new Sombrero(this));
            if(!facingRight()) {
                x -= 75;
                y += 5;
            }
            else {
                x += 75;
                y += 5;
            }
        }
        else {
            setEAbility(new GuacamoleTortillaChip(facingRight()));
        }
        getWorld().addObject(getEAbility(), x, y);
    }
    public void x() {
        World curWorld = getWorld();
        usedUlt = true;
        canCast = false;
        List<TortillaChip> chips = new ArrayList<TortillaChip>();
        rain.play();
        for(int k = 1; k <= 50; k++) {
            TortillaChip tc = new TortillaChip(this);
            int randX = rand.nextInt(curWorld.getWidth());
            int randY = rand.nextInt(curWorld.getHeight());
            getWorld().addObject(tc, randX, randY);
        }
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
}