import greenfoot.*;
public class EndScreen extends World {
    private Player winner;
    private Ability ab;
    private Color c;
    private ModeButton charSelect;
    private ModeButton stageSelect;
    //private button rematch;
    public EndScreen() {
        super(1200, 800, 1);
        charSelect = new ModeButton(300, 50,
        "Go to Character Select", -120, -40);
        makeScreen();
    }
    public EndScreen(Player winner, Ability ab, Color c) {
        this();
        this.winner = winner;
        this.c = c;
        this.ab = ab;
        playAnimation();
    }
    private void makeScreen() {
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(c);
        //bg.fill();
        addButtons();
    }
    private void playAnimation() {
        addObject(ab, 100, 500);
    }
    private void addButtons() {
        this.addObject(charSelect, 200, 400);
        //this.addObject(stageSelect, 400, 400);
    }
}
