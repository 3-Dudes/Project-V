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
        
        GreenfootImage modeLabel = new GreenfootImage(200, 50);
        modeLabel.setColor(Color.ORANGE);
        modeLabel.fill();
        bg.drawImage(label(modeLabel, "Domination", -65, -40), 200, 450);
        GreenfootImage stockedLabel = new GreenfootImage(200, 50);
        stockedLabel.setColor(Color.ORANGE);
        stockedLabel.fill();
        bg.drawImage(label(stockedLabel, "Stock", -30, -40), 500, 450);
        GreenfootImage timedLabel = new GreenfootImage(200, 50);
        timedLabel.setColor(Color.ORANGE);
        timedLabel.fill();
        bg.drawImage(label(timedLabel, "Time", -30, -40), 800, 450);
    }
    private GreenfootImage label(GreenfootImage img, String text, 
        int offsetX, int offsetY) {
        GreenfootImage labeledText = new GreenfootImage(text, 30, null, null);
        img.drawImage(labeledText, img.getWidth() / 2 + offsetX, 
            img.getHeight() + offsetY);
        return img;
    }
}