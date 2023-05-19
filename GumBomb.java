import greenfoot.*;
public class GumBomb extends Ability {
    private boolean movingRight;
    private boolean spawnedIn;
    private GreenfootSound pop = new GreenfootSound("gum.mp3");
    public GumBomb() {
        super(500, 10);
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        this.setImage(img);
    }
    public GumBomb(boolean movingRight) {
        this();
        this.movingRight = movingRight;
    }
    public void act() {
        moveGumBomb();
        if(this.exists()) {
            spawnedIn = true;
        }
        if(spawnedIn) {
            pop.play();
        }
        detectCollision("Balthazar");
        if(this.isTouching(Player.class) && !this.isTouching(Balthazar.class) 
            || this.isAtEdge()) {
            pop();
            isFinished = true;
        }
    }
    private void moveGumBomb() {
        if(movingRight) {
            this.setLocation(this.getX() + 10, this.getY());
        }
        else {
            this.setLocation(this.getX() - 10, this.getY());
        }
    }
    public void pop() {
        getWorld().removeObject(this);
        pop.stop();
    }
    public boolean exists() {
        return getWorld() != null;
    }
}