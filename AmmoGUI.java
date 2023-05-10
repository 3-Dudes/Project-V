import greenfoot.*;
import java.util.*;
public class AmmoGUI extends Actor {
    public int cur, max;
    private GreenfootImage chip;
    private int spaceX;
    public AmmoGUI(int cur, int max, GreenfootImage chip, 
        boolean pastHalfway, int spaceX, int widthFactor, int heightFactor) {
        this.max = max;
        this.cur = cur;
        this.chip = chip;
        this.spaceX = spaceX;
        chip.scale(chip.getWidth() / widthFactor, 
            chip.getHeight() / heightFactor);
    }

    @Override
    public void addedToWorld(World world) {
        updateImage(spaceX);
    }

    public void loseChip() {
        cur--;
        updateImage(spaceX);
    }

    public void refill() {
        this.cur = this.max;
        updateImage(spaceX);
    }

    public void updateImage(int spaceX) {
        GreenfootImage image = new GreenfootImage(175, 600);
        for(int i = 0; i < cur; i++) {
            image.drawImage(chip, 55, 500 - i * spaceX);
        }
        this.setImage(image);
    }
}