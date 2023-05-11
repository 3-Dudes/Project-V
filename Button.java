import greenfoot.*;
public abstract class Button extends Actor {
    public Button(Color c, int width, int height, String text) {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(c);
        img.fill();
        
        GreenfootImage buttonText = new GreenfootImage(text, 30, null, null);
        img.drawImage(buttonText, img.getWidth() / 2 - 35, img.getHeight() - 40);
        
        this.setImage(img);
    }
    public void act() {
        whenClicked();
    }
    public abstract void whenClicked();
}