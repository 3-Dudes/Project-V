import greenfoot.*;
public class WinScreen  extends World
{
    private Ability a;
    private Player p;
    public WinScreen(Player p)
    {
        super(1200, 700, 1);
        this.a = a;
        this.p = p;
        makeScreen();
        Greenfoot.stop();
    }
    
    private void makeScreen() {
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();
        GreenfootImage text = new GreenfootImage(p.getClass().getName() + " wins!", 
            60, Color.ORANGE, null);
        bg.drawImage(text, 500, 100);
        bg.drawImage(p.getImage(), 600, 350);
    }
}