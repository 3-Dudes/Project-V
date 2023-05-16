import greenfoot.*;
public class FreezeBlock extends Actor {
    private GreenfootImage block;
    public FreezeBlock(Player damagedPlayer) {
        GreenfootImage img = damagedPlayer.getImage();
        block = new GreenfootImage(img.getWidth(), img.getHeight());
        block.setColor(new Color(148, 245, 255));
        block.fill();
        this.setImage(block);
    }
}