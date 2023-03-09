import greenfoot.*;
public abstract class Ability extends Actor {
    private int charge;
    private int cooldown;
    private Integer damage;
    public Ability(int cooldown, Integer damage) {
        this.charge = cooldown;
        this.cooldown = cooldown;
        this.damage = damage;
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
}