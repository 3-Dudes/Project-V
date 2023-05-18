import greenfoot.*;
public class GruTeleportationEntrance extends Actor {
    private GreenfootImage ovalShadow;
    public GruTeleportationEntrance() {
        ovalShadow = new GreenfootImage(200, 10);
        ovalShadow.setColor(Color.RED);
        ovalShadow.drawOval(0, 0, 200, 10);
        ovalShadow.fillOval(0, 0, 200, 10);
        this.setImage(ovalShadow);
    }
    public boolean isInWorld() {
        return getWorld() != null;
    }
}
