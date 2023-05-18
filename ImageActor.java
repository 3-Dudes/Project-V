import greenfoot.*;
public class ImageActor extends Actor {
    private GreenfootImage img;
    private StageButton button;
    private boolean mouseHovered;
    private String text;
    private int xOffset;
    private int yOffset;
    private Stage st;
    private Player p;
    public ImageActor(GreenfootImage img, String text, int xOffset, int yOffset) {
        this.img = img;
        this.text = text;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.st = st;
        this.setImage(img);
        mouseHovered = false;
    }
    public ImageActor(GreenfootImage img, String text, int xOffset, int yOffset,
        Stage st) {
        this(img, text, xOffset, yOffset);
        this.st = st;
    }
    public ImageActor(GreenfootImage img, String text, int xOffset, 
        int yOffset, Player p) {
        this(img, text, xOffset, yOffset);
        this.p = p;
    }
    public void act() {
        if(isMouseOver() && !mouseHovered) {
            button = new StageButton(text, xOffset, yOffset);
            getWorld().addObject(button, this.getX(), this.getY() + 100);
            mouseHovered = true;
        }
        if(!isMouseOver() && mouseHovered) {
            getWorld().removeObject(button);
            mouseHovered = false;
        }
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(st);        
        }
    }
    public boolean isMouseOver() {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null) {
            int mx = m.getX();
            int my = m.getY();
            return getX() - getImage().getWidth()/2 < mx && getX() 
                + getImage().getWidth()/2 > mx && getY() - getImage().getHeight()/2 
            < my && getY() + getImage().getHeight()/2 > my;
        }
        return false;
    }
}