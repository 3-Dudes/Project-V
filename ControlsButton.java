import greenfoot.*;
public class ControlsButton extends Button {
    public ControlsButton() {
        super(Color.ORANGE, 200, 50, "Continue", -55, -40);
    }
    @Override
    public void whenClicked() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new CharacterSelect());
        }
    }
}
