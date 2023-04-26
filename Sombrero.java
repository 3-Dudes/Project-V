import greenfoot.*;
public class Sombrero extends Ability {
    private int health;
    private boolean intersects;
    public Sombrero() {
        super(800, 20);
        health = 100;
        intersects = false;
        this.setRotation(15);
    }
    public int getHealth() {
        return health;
    }
    public void act() {
        Ability a = (Ability) this.getOneIntersectingObject(null);
        if(a != null && !intersects) {
            health -= a.getDamage();
            intersects = true;
            getWorld().removeObject(a);
        }     
        if(health <= 0) {
            getWorld().removeObject(this);
        }
    }
}