import greenfoot.*;
public class BubbleGum extends Ability {
    private static GreenfootImage img;
    private boolean movingRight;
    private int bounces;
    private boolean spawnedIn;
    private GreenfootSound pop = new GreenfootSound("gum.mp3");
    public BubbleGum() {
        super(1400, 10);
        img = this.getImage();
        bounces = 0;
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        this.setImage(img);
        this.intersects = false;
    }
    public BubbleGum(boolean movingRight) {
        this();
        this.movingRight = movingRight;
    }
    
    @Override
    public void act() {
        super.act();
        if(this.exists()) {
            spawnedIn = true;
        }
        if(spawnedIn) {
            pop.play();
        }
        if(movingRight) {
            this.setLocation(this.getX() + 15, this.getY());
        }
        else {
            this.setLocation(this.getX() - 15, this.getY());
        }
        if(this.isAtEdge()) {
            if(movingRight) {
                movingRight = false;
            }
            else {
                movingRight = true;
            }
            bounces++;
            intersects = false;
        }
        if(bounces == 4) {
            pop();
            isFinished = true;
            return;
        }
        detectCollision("Balthazar");
    }
    public void pop() {
        getWorld().removeObject(this);
        pop.stop();
    }
    public boolean exists() {
        return getWorld() != null;
    }
}