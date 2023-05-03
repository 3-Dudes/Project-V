import greenfoot.*;
public class Lucy extends Player {
    private Flamethrower weapon;
    private Fire ammo;
    public Lucy() {
        super("Lucy", 2);
        GreenfootImage img = this.getImage();
        health = 300;
        hitpoints = 300;
        //img.scale(img.getWidth() / 2, img.getHeight() / 2);
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        int spaceX = 50;
        int spaceY = 20;
        weapon = new Flamethrower(this, spaceX, spaceY);
        ammo = new Fire(weapon, this);
        getWorld().addObject(weapon, this.getX() + spaceX, this.getY() - spaceY);
    }
    
    public void act() {
        super.act();
    }
    @Override
    protected void castMoves() {
        super.castMoves();
        if(Greenfoot.isKeyDown("X")) {
            x();
        }
        else {
            getWorld().removeObject(ammo);
        }
    }
    
    public void reload() {
        
    }
    public void burstFire() {
        
    }
    public void singleFire() {
        
    }
    public void c() {
        
    }
    public void q() {
        
    }
    public void e() {
        
    }
    public void x() {
        if(!weapon.isFiring()) {
            getWorld().addObject(ammo, weapon.getX() + 75, weapon.getY());
        }
    }
}