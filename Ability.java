import greenfoot.*;
public abstract class Ability extends Actor {
    private int charge;
    private int cooldown;
    private int damage;
    private boolean pastHalfway;
    protected boolean right;
    protected boolean intersects;
    protected boolean isFinished;
    private boolean isFacingRight;
    
    public Ability(int cooldown, int damage) {
        this.charge = cooldown;
        this.cooldown = cooldown;
        this.damage = damage;
        this.right = right;
        this.intersects = false;
        this.isFinished = false;
        this.pastHalfway = pastHalfway;
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
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getCooldown() {
        return cooldown;
    }
    public boolean isReady() {
        return charge == cooldown;
    } 
    public boolean isFinished() {
        return isFinished;
    }
    public void detectCollision(String name) {
        if(getWorld() != null) {
            Player hitPlayer = (Player) this.getOneIntersectingObject(Player.class);   
            if(hitPlayer != null && !hitPlayer.getClass().getName().equals(name)
                    && !intersects) {
                hitPlayer.decreaseHealth(this.getDamage());
                intersects = true;
            }
        }
    }
}