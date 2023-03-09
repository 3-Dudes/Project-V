import greenfoot.*;
public class Balthazar extends Player
{
    private BubbleGum gum;
    private boolean cPressed;
    public Balthazar() {
        GreenfootImage thisImg = this.getImage();
        thisImg.scale(thisImg.getWidth() / 2, thisImg.getHeight() / 2);
        setImage(thisImg);
        cPressed = false;
        gum = new BubbleGum();
    }
    public void c() {
        
    }
    public void e() {
        
    }
    public void x() {
        
    }
    public void q() {
        getWorld().addObject(gum, this.getX() + 10, this.getY());
    }
    public void singleFire() { }
    public void burstFire() { }
    public void reload() { }
}