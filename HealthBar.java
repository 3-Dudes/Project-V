import greenfoot.*;
public class HealthBar extends Actor {
    private GreenfootImage bar;
    public HealthBar() {    
        bar = new GreenfootImage(200, 50);
        bar.drawRect(500, 500, bar.getWidth(), bar.getHeight());
        bar.setColor(Color.GREEN);
        bar.fill();

        GreenfootImage header = new GreenfootImage("Health", 25, null, null);
        bar.drawImage(header, bar.getWidth() / 2 - 30, 15);
        setImage(bar);
    }
}