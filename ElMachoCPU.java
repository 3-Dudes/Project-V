import greenfoot.*;
import java.util.*;
public class ElMachoCPU extends CPU {
    private AmmoGUI ammoGui;
    private int timeToReload;
    private boolean needToReload;
    private boolean rPressed;
    public boolean usedUlt;
    public int ultDur;
    public boolean isEduardo;
    private Random rand; 
    private static GreenfootImage[] machoLeftFrames;
    private static GreenfootImage[] machoRightFrames;
    private static GreenfootImage[] eduardoLeftFrames;
    private static GreenfootImage[] eduardoRightFrames;
    
    private Player p;
    public ElMachoCPU() {
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
        ammoGui = new AmmoGUI(5, 5, new TortillaChip(facingRight(), this).getImage(), 
            pastHalfway, 50, 1, 1);
        changePersona();
    }
    
    

    public Player getPlayerReference() {
        List<Player> players = getObjectsInRange(getWorld().getWidth(), Player.class);
        if(players.size() == 1) {
            return players.get(0);
        }
        return null;
    }

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        if(pastHalfway) {
            this.setImage(getLeftImage());
            getWorld().addObject(ammoGui, 1150, 400);
        }
        else {
            this.setImage(getRightImage());
            getWorld().addObject(ammoGui, 45, 400);
        }
        if(getWorld().getObjects(Player.class).size() > 0) {
            p=getWorld().getObjects(Player.class).get(0);
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
    int pheight=Player.getY();
    int move=0;
    @Override
    public void act() {
        super.act();
        checkAbilities();
        if(Player.getX()>this.getX()){ //if enemy is to right of T-9000
            super.isFacingRight=true;
        } else{ //player is to left of T-9000
            super.isFacingRight=false;
        }

        if( Math.abs(p.getX()-this.getX()) > 400 && (p.getX()-this.getX())<600){ // moves towards human if far
            rand=Greenfoot.getRandomNumber(3);
            switch (move) {
                case 0:
                    singleFire();
                    break;
                case 1:
                    WrestlingChamp();
                    break;
                case 2:
                    e();
                    break;
                default:
                    break;
            }
            if(super.isFacingRight){this.setLocation(this.getX() - 5, this.getY());} else{this.setLocation(this.getX() - 5, this.getY());}
        }
        else if(math.abs(Player.getX()-this.getX())>600){ // moves towards human if far
            WrestlingcahmpChamp();
        }
        else{
            burstFire();
        }
        //detect if human jumps (WILL NEED FIX)
        if(Player.getY()!=pheight()){
            burstFire();
        }
        
        //1 in 600,000 cahnce to jump every act method
        rand=Greenfoot.getRandomNumber(600001);
        if(rand==69){
            jump();
        }
        
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
        for(int k = 1; k <= 50; k++) {
            TortillaChip tc = new TortillaChip(this);
            int randX = rand.nextInt(curWorld.getWidth());
            int randY = rand.nextInt(curWorld.getHeight());
            getWorld().addObject(tc, randX, randY);
        }
    }
}