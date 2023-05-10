import greenfoot.*;
public class Sombrero extends Ability {
    private int health;
    private int time;
    private ElMacho macho;
    private static GreenfootImage right;
    private static GreenfootImage left;
    public Sombrero(ElMacho macho) {
        super(800, 20);
        this.macho = macho;
        health = 100;
        time = 0;
        this.setRotation(105);
        right = getImage();
        left = new GreenfootImage(right);
        left.mirrorVertically();
        left.rotate(-25);
    }
    public int getHealth() {
        return health;
    }
    public void act() {
        if(macho.facingRight()) {
            this.setLocation(macho.getX() + 75, macho.getY() + 5); 
            this.setImage(right);
        }
        else {
            this.setLocation(macho.getX() - 75, macho.getY() + 5);
            this.setImage(left);
        }
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
    }
}