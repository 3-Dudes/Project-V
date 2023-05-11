import greenfoot.*;
public abstract class Button extends Actor {
    public Button(Color c, int width, int height) {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(c);
        img.fill();
        
        GreenfootImage text = new GreenfootImage("START", 20, null, null);
        img.drawImage(text, img.getWidth() / 2, img.getHeight());
        
        this.setImage(img);
    }
    public void act() {
        whenClicked();
    }
    public abstract void whenClicked();
}