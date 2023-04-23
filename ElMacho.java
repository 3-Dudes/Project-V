import greenfoot.*;
import java.util.*;
public class ElMacho extends Player {
    //private Stack<TortillaChip> ammo;   
    //private int ammoCount;
    private AmmoGUI ammoGui;
    private int timeToReload;
    private boolean needToReload;
    private boolean vPressed;
    private boolean bPressed;
    private boolean rPressed;
    public boolean usedUlt;
    public int ultDur;
    
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
        ultDur = 0;
        rand = new Random();
        e = new GuacamoleTortillaChip();
    }

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        ammoGui = new AmmoGUI(5, 5, 
            new TortillaChip(facingRight(), this).getImage(), pastHalfway);
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

    public void act() {
        super.act();
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
        checkAbilities();
    }    

    public void q() {
        this.setImage((GreenfootImage) null);
        new WrestlingChamp(true);
    }

    public void c() {
        
    }   

    public void e() {
        getWorld().addObject(e, this.getX(), this.getY());    
    }
    
    public void x() { //make it rain(macho ult)
        /*idea is to make several big chips in the sky that flash before they 
         * fall down in random orders (disable firing so not too OP)
         */
        
        
        //Anirudh
        //my approach to el macho's ult
        World curWorld = getWorld();
        usedUlt = true;
        
        List<TortillaChip> chips = new ArrayList<TortillaChip>();
        for(int k = 1; k <= 50; k++) {
            TortillaChip tc = new TortillaChip(this);
            int randX = rand.nextInt(curWorld.getWidth());
            int randY = rand.nextInt(curWorld.getHeight());
            getWorld().addObject(tc, randX, randY);
        }
    }
}