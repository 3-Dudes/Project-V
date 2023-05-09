import greenfoot.*;
public class Sombrero extends Ability {
    private int health;
    private int time;
    private ElMacho macho;
    private static GreenfootImage left;
    private static GreenfootImage right;
    public Sombrero() {
        super(800, 20);
        health = 100;
        time = 0;
        this.setRotation(105);
        right = this.getImage();
        left = new GreenfootImage(right);
        left.rotate(180);
    }
    public Sombrero(ElMacho macho) {
        this();
        this.macho = macho;
    }
    public int getHealth() {
        return health;
    }
    public void act() {
        Ability a = (Ability) this.getOneIntersectingObject(Ability.class);
        if(macho != null) {
            if(macho.facingRight()) {
                this.setLocation(macho.getX() + 75, macho.getY() + 5); 
                this.setImage(right);
            }
            else {
                this.setLocation(macho.getX() - 75, macho.getY() - 15);
                this.setImage(left);
            }
        }
        if(a != null) {
            health -= a.getDamage();
            getWorld().removeObject(a);
        }     
        if(health <= 0 || time == 300) {
            getWorld().removeObject(this);
            isFinished = true;
            time = 0;
        }
        time++;
    }
}