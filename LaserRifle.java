import greenfoot.*;
public class LaserRifle extends Weapon {
    private Gru g;
    private int spaceX;
    private int spaceY;
    public LaserRifle(Gru g, int spaceX, int spaceY) {
        super(g, spaceX, spaceY, 8, 8);
        this.g = g;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
    }
    public void act() {
        this.setLocation(g.getX() + 100, g.getY() + 50);
    }
}
