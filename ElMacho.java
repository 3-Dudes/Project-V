import greenfoot.*;
import java.util.*;
public class ElMacho extends Player {
    private Stack<TortillaChip> ammo;   
    private AmmoGUI ammoGui;
    
    private boolean vPressed;
    private boolean bPressed;
    private boolean rPressed;
    public ElMacho() {
        super("El Macho");
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        setImage(img);
        health = 700;
        hitpoints = 700;
        
        vPressed = false;
        bPressed = false;
        rPressed = false;
        
        ammoGui = new AmmoGUI(5, 5, new GreenfootImage("tortilla_chip.png"));
        reload();
        e = new GuacamoleTortillaChip();
        q = new BubbleGum();
    }
    
    @Override
    public void addedToWorld(World world) {
        getWorld().addObject(ammoGui, 5, 400);
    }
    
    public void singleFire() {
        getWorld().addObject(ammo.pop(), getX(), getY());
        ammoGui.loseChip();
    }
    public void burstFire() {
        int a = 0;
        for(int k = 1; k <= 3; k++) {
            getWorld().addObject(ammo.pop(), getX() + a, getY());
            a += 60;
        }
        for(int k = 1; k <= 3; k++) {
            ammoGui.loseChip();
        }
    }
    public void reload() {
        ammo = new Stack<TortillaChip>();
        for(int k = 1; k <= 6; k++) {
            ammo.push(new TortillaChip());
        }
        ammoGui.refill();
    }    
    
    public void act() {
        super.act();
        if(ammo.size() <= 0) {
            reload();
        } 
        if(ammo.size() >= 3 && Greenfoot.isKeyDown("B") && !bPressed) {
            bPressed = true;
            burstFire();
        }
        if(!Greenfoot.isKeyDown("B") && bPressed) {
            bPressed = false;
        } 
        
        if(Greenfoot.isKeyDown("V") && !vPressed) {
            vPressed = true;
            singleFire();
        }
        if(!Greenfoot.isKeyDown("V") && vPressed) {
            vPressed = false;
        }
        
        if(Greenfoot.isKeyDown("R") && !rPressed){
            rPressed = true;
            reload();
        }
        if(!Greenfoot.isKeyDown("R") && rPressed) {
            rPressed = false;
        }
        checkAbilities();
    }    
    
    public void q() {
        
    }
    public void c() {
        
    }
    public void e() {
        getWorld().addObject(e, this.getX(), this.getY());    
    }
    public void x() {
        
    }
}