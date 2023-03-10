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
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        setImage(img);
        health = 300;
        
        vPressed = false;
        bPressed = false;
        rPressed = false;
               
        reload();
        e = new GuacamoleTortillaChip();
        q = new BubbleGum();
        this.showAmmoCounter();
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
        if(this.isDead()) {
            actors = new ArrayList<Actor>(getWorld().getObjects(Actor.class));
            posX = new ArrayList<Integer>();
            posY = new ArrayList<Integer>();
            rotation = new ArrayList<Integer>();
            for(int i = 0; i < actors.size(); i++) {
                posX.add(actors.get(i).getX());
                posY.add(actors.get(i).getY());
                rotation.add(actors.get(i).getRotation());
            }
            Greenfoot.setWorld(new KillCam(actors, posX, posY, rotation));        
        }
        System.out.println(this.getHealth());
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