import greenfoot.*;
public class Waffle extends Ability {
    private int duration;
    private boolean right;
    private boolean spawnedIn;
    private GreenfootSound whoosh = new GreenfootSound("cartoony-whooshes-7114.mp3");
    public Waffle(boolean right) {
        super(1100, 20);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        duration = 0;//
        this.right = right;
    }
    public void act() {
        if(this.exists()) {
            spawnedIn = true;
        }
        if(spawnedIn) {
            whoosh.play();
        }
        if(right) {
            this.setLocation(this.getX() + 15, this.getY());    
        }
        else {
            this.setLocation(this.getX() - 15, this.getY());
        }
        switch(duration) {
            case 2:
                this.setRotation(90);
                break;
            case 4:
                this.setRotation(180);
                break;
            case 6:
                this.setRotation(270);
                break;
            case 8:
                this.setRotation(360);
                break;
            case 10:
                duration = 0;
                this.setRotation(0);
                break;
        }
        duration += 2;
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
            isFinished = true;
        }
        detectCollision("ElMacho");
    }
    public boolean exists() {
        return getWorld() != null;
    }
}