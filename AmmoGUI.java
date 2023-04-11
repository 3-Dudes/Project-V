import greenfoot.*;
public class AmmoGUI extends Actor {
    private int cur, max;
    private GreenfootImage chip;
    public AmmoGUI(int cur, int max, GreenfootImage chip) {
        this.max = max;
        this.cur = cur;
        this.chip = chip;
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
        chip.scale(100,100);
        for(int i = 0; i < cur; i++) {
            image.drawImage(chip, 50, 500-i*50);
        }
        this.setImage(image);
    }
}
