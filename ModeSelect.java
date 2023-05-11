import greenfoot.*;
public class ModeSelect extends World {
    public ModeSelect() {
        super(1200, 700, 1);
        makeScreen();
    }
    private void makeScreen() {
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(Color.BLACK);
        bg.fill();
        this.setBackground(bg);
        
        ModeButton dominationButton = new ModeButton("Domination", -65, -40);
        ModeButton stockButton = new ModeButton("Stock", -30, -40);
        ModeButton timeButton = new ModeButton("Time", -30, -40);
        this.addObject(dominationButton, 300, 550);
        this.addObject(stockButton, 600, 550);
        this.addObject(timeButton, 900, 550);
        /* bg.drawImage(label(modeLabel, "Domination", -65, -40), 200, 550);
        GreenfootImage stockedLabel = new GreenfootImage(200, 50);
        stockedLabel.setColor(Color.ORANGE);
        stockedLabel.fill();
        bg.drawImage(label(stockedLabel, "Stock", -30, -40), 500, 550);
        GreenfootImage timedLabel = new GreenfootImage(200, 50);
        timedLabel.setColor(Color.ORANGE);
        timedLabel.fill();
        bg.drawImage(label(timedLabel, "Time", -30, -40), 800, 550); */
    }
}