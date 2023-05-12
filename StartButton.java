import greenfoot.*;
public class StartButton extends Button
{
    private int x;
    private GreenfootImage img;
    public StartButton() {
        super(Color.ORANGE, 200, 50, "START", -35, -40);
        x = 0;
        img = getImage();
        img.setTransparency(x);
    }
    public void whenClicked() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new ModeSelect());
        }
    }
    public void act() {
        super.act();
        if(x < 255) {
            x += 5;
            img.setTransparency(x);
            this.setImage(img);
        }
    }
}