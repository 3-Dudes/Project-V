import greenfoot.*;
public class PiranhaGun extends Weapon {
    public PiranhaGun() {
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 4, img.getHeight() / 4);
        setImage(img);
    }
}
