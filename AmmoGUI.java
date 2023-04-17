import greenfoot.*;
public class AmmoGUI extends Actor {
    private int cur, max;
    private GreenfootImage chip;
    public AmmoGUI(int cur, int max, GreenfootImage chip, boolean pastHalfway) {
        this.max = max;
        this.cur = cur;
        this.chip = chip;
        if(pastHalfway) {
            this.chip.mirrorHorizontally();
        }
    }

    @Override
    public void addedToWorld(World world) {
        updateImage();
    }
    
    public void loseChip() {
        cur--;
        updateImage();
    }
    
    public void refill() {
        this.cur = this.max;
        updateImage();
    }

    public void updateImage() {
        GreenfootImage image = new GreenfootImage(100,600);
        for(int i = 0; i < cur; i++) {
            image.drawImage(chip, 55, 500-i*50);
        }
        this.setImage(image);
    }
}
