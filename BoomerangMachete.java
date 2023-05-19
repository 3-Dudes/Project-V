import greenfoot.*;
public class BoomerangMachete extends Weapon {
    private GreenfootImage left;
    private GreenfootImage right;
    private boolean movingRight;
    private int bounces;
    private Balthazar b;
    private boolean spawnedIn;
    private GreenfootSound whoosh = new GreenfootSound("cartoony-whooshes-7114.mp3");
    public BoomerangMachete() {
        super(4, 4);
        left = getImage();
        right = new GreenfootImage(left);
        right.mirrorHorizontally();
        movingRight = true;
        bounces = 0;
    }
    public BoomerangMachete(Balthazar b, boolean movingRight) {
        this();
        this.b = b;
        this.movingRight = movingRight;
    }
    public void act() {
        if(this.exists()) {
            spawnedIn = true;
        }
        if(spawnedIn) {
            whoosh.play();
        }
        if(movingRight) {
            this.setImage(right);
            this.setLocation(this.getX() + 10, b.getY());
        }
        else {
            this.setImage(left);
            this.setLocation(this.getX() - 10, b.getY());
        }
        if(this.isAtEdge()) {
            if(movingRight) {
                movingRight = false;
                this.setImage(left);
            }
            else {
                movingRight = true;
                this.setImage(right);
            }
            bounces++;
            if(bounces == 1) {
                b.setLocation(b.getX(), this.getY());
            }
            intersects = false;
        }
        if(bounces == 1 && (this.isTouching(Balthazar.class))) {
            getWorld().removeObject(this);
            whoosh.stop();
        }
        detectCollision("Balthazar", 10);
    }
    @Override
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            Player player = (Player) 
                getOneObjectAtOffset(0, 0, Player.class);
            if(player != null && !(player.getClass().getName().equals(name)) 
                && !intersects) {
                player.decreaseHealth(damage);
                intersects = true;
            }
        }
    }
    public boolean exists() {
        return getWorld() != null;
    }
}