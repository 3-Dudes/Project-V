import greenfoot.*;
public class GuacamoleTortillaChipStatic extends Actor
{
    public GuacamoleTortillaChipStatic() {
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 5, img.getHeight() / 5);
        img.mirrorHorizontally();
        setImage(img);
    }
}
