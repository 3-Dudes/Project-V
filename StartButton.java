import greenfoot.*;
public class StartButton extends Button
{
    public StartButton() {
        super(Color.ORANGE, 200, 50, "START");
    }
    public void whenClicked() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new ModeSelect());
        }
    }
}
