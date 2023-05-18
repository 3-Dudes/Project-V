import greenfoot.*;
import java.util.*;
public class Gru extends Player {
    private LaserRifle mainWeapon;
    private FreezeRay freezeRay;
    private boolean automate;
    private int automationDuration;
    private int fireDelay;
    public Gru() {
        super("Gru", 2, false, 500, 500, "gru", 5);
        mainWeapon = new LaserRifle(this, 100, 40);
        freezeRay = new FreezeRay(this);
        setQAbility(freezeRay);
        automate = false;
        automationDuration = 0;
        fireDelay = 0;
    }

    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        if(facingRight()) {
            getWorld().addObject(mainWeapon, this.getX() + 100, 
                this.getY() - 40);
            mainWeapon.setImage(mainWeapon.getRightImage());
        }
        else {
            getWorld().addObject(mainWeapon, this.getX() - 100, 
                this.getY() - 40);
            mainWeapon.setImage(mainWeapon.getLeftImage());
        }
    }

    public void c() {
        if(this.isTouching(LaserRifle.class)) {
            getWorld().removeObject(mainWeapon);
        }    
    }

    public void q() {
        if(this.isTouching(LaserRifle.class)) {
            getWorld().removeObject(mainWeapon);
        }
        if(facingRight()) {
            getWorld().addObject(getQAbility(), this.getX() + 100, 
                this.getY() - 60);    
        }
        else {
            getWorld().addObject(getQAbility(), this.getX() - 100,
                this.getY() - 60);
        }
    }

    public void e() {

    }
private Rocket r;
    public void x() { //teleport to opposite x coord and fire rocket back at other side
        if(this.getX()>=600){
            this.setLocation(this.getX()-600,this.getY());
            SetRight(true);
            r=new Rocket(this, 10, 10, true);
        }
        else{
            SetRight(false);
            this.setLocation(this.getX()+600,this.getY());
            r=new Rocket(this, 10, 10, false);
        }
        getWorld().addObject(r, this.getX(), this.getY());
    }

    public void singleFire() {
        if(this.isTouching(LaserRifle.class)) {
            if(automate) {
                if(fireDelay == 20 || fireDelay == 0) {
                    addLaser();
                    fireDelay = 0;
                }
                fireDelay++;    
            }
            else {
                addLaser();
            }
        }
    }

    private void addLaser() {
        if(facingRight()) {
            getWorld().addObject(new RedLaser(this), 
                mainWeapon.getX() + 110, mainWeapon.getY() - 15);    
        }
        else {
            getWorld().addObject(new RedLaser(this), 
                mainWeapon.getX() - 110, mainWeapon.getY() - 15);
        }
    }

    public void burstFire() {
        automate = true;
    }   

    public void act() {
        super.act();
        if(!this.isTouching(Weapon.class) 
        && !this.isTouching(Ability.class)) {
            mainWeapon = new LaserRifle(this, 100, 40);
            if(facingRight()) {
                getWorld().addObject(mainWeapon, this.getX() + 100, 
                    this.getY() - 30);
            }
            else {
                getWorld().addObject(mainWeapon, this.getX() - 100, 
                    this.getY() - 30);
            }
        }
        automatic();
        if(automationDuration == 200) {
            automate = false;
            automationDuration = 0;
        }
    }

    private void automatic() {
        if(automate) {
            automationDuration++;
            if(Greenfoot.isKeyDown("V")) {
                singleFire();
            }
        }
    }
}