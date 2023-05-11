import greenfoot.*;
public class ModeButton extends Button {
    public ModeButton(String text, int offsetX, int offsetY) {
        super(Color.ORANGE, 200, 50, text, offsetX, offsetY);
    }
    @Override
    public void whenClicked() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new CharacterSelect());
        }
    }
}
