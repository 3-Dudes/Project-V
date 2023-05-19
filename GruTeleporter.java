import greenfoot.*;
public class GruTeleporter extends Actor {
    private GreenfootImage ovalShadow;
    public GruTeleporter() {
        ovalShadow = new GreenfootImage(200, 10);
        ovalShadow.setColor(Color.BLACK);
        ovalShadow.drawOval(0, 0, 200, 10);
        ovalShadow.fillOval(0, 0, 200, 10);
        this.setImage(ovalShadow);
    }
    public boolean isInWorld() {
        return getWorld() != null;
    }
}
