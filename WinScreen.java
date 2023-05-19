import greenfoot.*;
public class WinScreen  extends World
{
    private Ability a;
    public WinScreen(Player p, Ability a)
    {
        super(1200, 700, 1);
        this.a = a;
    }

    private void playAnimation(Ability a) {
        this.addObject(a, 100, this.getHeight() / 2);
    }
    
    public void act() {
        playAnimation(a);
        if(a.isAtEdge()) {
            this.removeObject(a);
        }
    }
}
