import greenfoot.*;
public class Minion extends Ability {
    private GreenfootImage img;
    private boolean spawnedIn;
    private GreenfootSound minion = new GreenfootSound("gru-MINION_.mp3");
    public Minion() {
        super(10, 0);
        img = this.getImage();
        img.scale(img.getWidth() / 4, img.getWidth() / 4);
    }
    public void act() {
        if(this.exists()) {
            spawnedIn = true;
        }
        if(spawnedIn) {
            minion.play();
        }
    }    
    public boolean exists() {
        return getWorld() != null;
    }
}
