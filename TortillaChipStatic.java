import greenfoot.*;
public class TortillaChipStatic extends Actor {
    public TortillaChipStatic() {
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 5, img.getHeight() / 5);
        setImage(img);
    }
}
