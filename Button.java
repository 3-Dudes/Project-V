import greenfoot.*;
public abstract class Button extends Actor {
    public Button(Color c, int width, int height, String text, 
        int offsetX, int offsetY) {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(c);
        img.fill();
        GreenfootImage buttonText = new GreenfootImage(text, 30, null, null);
        img.drawImage(buttonText, img.getWidth() / 2 + offsetX, 
            img.getHeight() + offsetY);
        
        this.setImage(img);
    }
    public void act() {
        whenClicked();
    }
    public abstract void whenClicked();
}