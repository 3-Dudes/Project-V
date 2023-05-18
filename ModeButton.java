import greenfoot.*;
public class ModeButton extends Button {
    public ModeButton(int width, int height, 
        String text, int offsetX, int offsetY) {
            //200, 50
        super(Color.ORANGE, width, height, text, offsetX, offsetY);
    }
    @Override
    public void whenClicked() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new CharacterSelect());
        }
    }
}
