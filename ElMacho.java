import greenfoot.*;
import java.util.*;
public class ElMacho extends Player {
    private Stack<TortillaChip> ammo;   
    
    private boolean vPressed;
    private boolean bPressed;
    private boolean rPressed; 
    
    private ArrayList<Actor> actors;
    private ArrayList<Integer> posX, posY, rotation;
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
        
        reload();
        e = new GuacamoleTortillaChip();
        q = new BubbleGum();
    }
    
    private void showAmmoCounter() {
        
    }
    
    public void singleFire() {
        getWorld().addObject(ammo.pop(), getX(), getY());
    }
    public void burstFire() {
        int a = 0;
        for(int k = 1; k <= 3; k++) {
            getWorld().addObject(ammo.pop(), getX() + a, getY());
            a += 60;
        } 
    }
    public void reload() {
        ammo = new Stack<TortillaChip>();
        for(int k = 1; k <= 15; k++) {
            ammo.push(new TortillaChip());
        }
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