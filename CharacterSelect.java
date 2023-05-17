import greenfoot.*;
import java.util.*;
public class CharacterSelect extends World {
    public CharacterSelect() {    
        super(1200, 700, 1);  
        makeScreen();
    }
    private void makeScreen() {
        GreenfootImage img = getBackground();
        img.setColor(Color.BLACK);
        img.fill();
        this.setBackground(img);
        
        GreenfootImage text = new GreenfootImage("Select Your Character", 60, Color.ORANGE, null);
        getBackground().drawImage(text, 350, 50);
    }
}