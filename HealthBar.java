import greenfoot.*;
public class HealthBar extends Actor {
    private GreenfootImage bar;
    private GreenfootImage header;
    public HealthBar(String name) {
        bar = new GreenfootImage(300, 25);
        bar.drawRect(500, 500, bar.getWidth(), bar.getHeight());
        bar.setColor(Color.GREEN);
        bar.fill();

        header = new GreenfootImage(name, 25, null, null);
        drawHeader();
        this.setImage(bar);
    }
    public void drawHeader() {
        bar.drawImage(header, bar.getWidth() / 2 - 45, 2);
    }
}