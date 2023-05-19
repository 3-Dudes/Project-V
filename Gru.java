import greenfoot.*;
import java.util.*;
public class Gru extends Player {
    private LaserRifle mainWeapon;
    private FreezeRay freezeRay;
    private boolean automate;
    private int automationDuration;
    private int fireDelay;
    private Rocket r;
    private GruTeleporter entrance;
    private GruTeleporter exit;
    private int x;
    public Gru() {
        super("Gru", 2, false, 500, 500, "gru", 5);
        mainWeapon = new LaserRifle(this, 100, 40);
        freezeRay = new FreezeRay(this);
        setQAbility(freezeRay);
        automate = false;
        automationDuration = 0;
        fireDelay = 0;
        x = 0;
        entrance = new GruTeleporter();
        exit = new GruTeleporter();
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
        r = new Rocket(facingRight());
    }

    public void c() {
        
    }

    public void q() {
        canCast = false;
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
    
    public void x() {
        if(facingRight()) {
            this.setImage(getLeftImage());
            r = new Rocket(facingRight());
            if(!entrance.isInWorld()) {
                getWorld().addObject(entrance, this.getX() + 200, this.getY() + getImage().getHeight() / 3 + 15);
            }
            this.setLocation(this.getX() + 200, this.getY());
        }
        else {
            this.setImage(getRightImage());
            r = new Rocket(facingRight());
            if(!entrance.isInWorld()) {
                getWorld().addObject(entrance, this.getX() - 200, this.getY() + getImage().getHeight() / 3 + 15);
            }
            this.setLocation(this.getX() - 200, this.getY());
        }
        canMove = false;
        canCast = false;
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
        if(entrance.isInWorld() || exit.isInWorld()) {
            fade();
        }
        if(r.exists()) {
            canMove = true;
        }
        if(!r.exists() && r.isFinished()) {
            exit = new GruTeleporter();
            if(facingRight()) {
                getWorld().addObject(exit, this.getX() - 200, this.getY() + getImage().getHeight() / 3 + 15);
                this.setLocation(this.getX() - 200, this.getY());
            }
            else {
                getWorld().addObject(exit, this.getX() + 200, this.getY() + getImage().getHeight() / 3 + 15);
                this.setLocation(this.getX() + 200, this.getY());
            }
            getImage().setTransparency(0);
            r.updateMoveStatus(false);
        }
    }
    private void fade() {
        GreenfootImage img = null;
        if(facingRight()) {
            img = getRightImage();
        }
        else {
            img = getLeftImage();
        }
        img.setTransparency(0);
        if(img.getTransparency() < 250) {
            x += 5;
            img.setTransparency(x);
            this.setImage(img);
        }
        if(x == 250) {
            x = 0;
            if(entrance.isInWorld()) {
                getWorld().removeObject(entrance);
                getWorld().addObject(r, this.getX(), this.getY());    
            }
            if(exit.isInWorld()) {
                getWorld().removeObject(exit);
                canCast = true;
            }
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