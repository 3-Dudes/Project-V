import greenfoot.*;
import java.awt.*;
public class ModeSelect extends World {
    public ModeSelect() {
        super(1200, 700, 1);
        makeScreen();
    }
    private void makeScreen() {
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(greenfoot.Color.BLACK);
        bg.fill();
        this.setBackground(bg);
        
        ModeButton dominationButton = new ModeButton(200, 50,"Domination", -65, -40);
        ModeButton stockButton = new ModeButton(200, 50, "Stock", -30, -40);
        ModeButton timeButton = new ModeButton(200, 50,"Time", -30, -40);
        this.addObject(dominationButton, 300, 550);
        this.addObject(stockButton, 600, 550);
        this.addObject(timeButton, 900, 550);
    }
}