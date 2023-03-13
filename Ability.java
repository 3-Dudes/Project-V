import greenfoot.*;
public abstract class Ability extends Actor {
    private int charge;
    private int cooldown;
    private int damage;
    protected boolean intersects;
    public Ability(int cooldown, int damage) {
        this.charge = cooldown;
        this.cooldown = cooldown;
        this.damage = damage;
        this.intersects = false;
    }
    
    public int getCharge() {
        return charge;
    }
    public void setCharge(int charge) {
        this.charge = charge;
    }
    public int getDamage() {
        return damage;
    }
    public int getCooldown() {
        return cooldown;
    }
    
    public boolean abilityReady() {
        return charge == cooldown;
    }
    
    public void detectCollision(String name) {
        if(getWorld() != null) {
            Player p = (Player) this.getOneIntersectingObject(Player.class);
            if(this.isTouching(Shield.class)) {
                return;
            }   
            if(p != null && !p.getClass().getName().equals(name)
                    && !intersects) {
                p.decreaseHealth(this.getDamage());
                intersects = true;
            }
        }
    }
}