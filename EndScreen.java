import greenfoot.*;
public class EndScreen extends World {
    private Player winner;
    private Ability ab;
    private Color c;
    public EndScreen(Player winner, Ability ab, Color c) {
        super(1200, 800, 1);
        this.winner = winner;
        this.c = c;
        this.ab = ab;
        makeScreen();
        playAnimation();
    }
    private void makeScreen() {
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(c);
        bg.fill();
    }
    private void playAnimation() {
        addObject(ab, 100, 500);
    }
}
