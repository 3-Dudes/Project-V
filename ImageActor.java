import greenfoot.*;
public class ImageActor extends Actor {
    private GreenfootImage img;
    private StageButton button;
    private boolean buttonExists;
    public ImageActor(GreenfootImage img) {
        this.img = img;
        this.setImage(img);
        buttonExists = false;
    }    

    public void act() {
        if(isMouseOver() == false && buttonExists == true) {
            getWorld().removeObjects(getWorld().getObjects(Button.class));
            buttonExists = false;
        }
        if(isMouseOver() && buttonExists == false) {
            System.out.println("OVER");
            button = new StageButton("Gru's House", -60, -30); 
            getWorld().addObject(button, this.getX(), this.getY() + 100);
            buttonExists = true;
        }
        
    }

    public boolean isMouseOver() {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null) {
            int mx = m.getX();
            int my = m.getY();
            //System.out.println(mx+" "+my);
            if(getX() - getImage().getWidth()/2 < mx && getX() + getImage().getWidth()/2 > mx && 
            getY() - getImage().getHeight()/2 < my && getY() + getImage().getHeight()/2 > my) {
                return true;  
            }
        }
        return false;
    }
}