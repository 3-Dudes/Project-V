import greenfoot.*;
public class Sombrero extends Ability {
    private int health;
    private int time;
    public Sombrero() {
        super(800, 20);
        health = 100;
        time = 0;
        this.setRotation(105);
    }
    public int getHealth() {
        return health;
    }
    public void act() {
        Ability a = (Ability) this.getOneIntersectingObject(Ability.class);
        if(a != null) {
            health -= a.getDamage();
            getWorld().removeObject(a);
        }     
        if(health <= 0 || time == 800) {
            getWorld().removeObject(this);
            isFinished = true;
            time = 0;
        }
        time++;
        System.out.println(getCharge());
    }
}