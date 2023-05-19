import greenfoot.*;
import java.util.List;
public class LaserRifle extends Weapon {
    private Gru g;
    private int spaceX;
    private int spaceY;
    public LaserRifle(Gru g, int spaceX, int spaceY) {
        super(g, spaceX, spaceY, false, 10, 10);
        this.g = g;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
    }
}