import greenfoot.*;
public class StartButton extends Button
{
    public StartButton() {
        super(Color.ORANGE, 100, 50);
    }
    public void whenClicked() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new ModeSelect());
        }
    }
}
