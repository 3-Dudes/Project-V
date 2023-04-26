import greenfoot.*;
public class Sombrero extends Ability {
    private int health;
    public Sombrero() {
        super(800, 20);
        health = 100;
        this.setRotation(15);
    }
    public int getHealth() {
        return health;
    }
}