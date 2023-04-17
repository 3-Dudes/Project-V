import greenfoot.*;
public class PiranhaGun extends Weapon {
    public PiranhaGun() {
        super(new Vector());
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 4, img.getHeight() / 4);
        setImage(img);
    }
}
