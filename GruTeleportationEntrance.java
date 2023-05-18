import greenfoot.*;
public class GruTeleportationEntrance extends Actor {
    private GreenfootImage ovalShadow;
    private int x;
    public GruTeleportationEntrance() {
        ovalShadow = new GreenfootImage(200, 10);
        ovalShadow.setColor(Color.RED);
        ovalShadow.drawOval(0, 0, 200, 10);
        ovalShadow.fillOval(0, 0, 200, 10);
        x = 0;
        ovalShadow.setTransparency(x);
        this.setImage(ovalShadow);
    } 
    public void fade() {
        if(ovalShadow.getTransparency() < 250) {
            x += 5;
            ovalShadow.setTransparency(x);
            this.setImage(ovalShadow);
        }
    }
    public void act() {
        fade();
    }
}
