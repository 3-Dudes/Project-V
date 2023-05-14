import greenfoot.*;
public class BoomerangMachete extends Weapon {
    private boolean b;
    private GreenfootImage left;
    private GreenfootImage right;
    private boolean movingRight;
    private int bounces;
    public BoomerangMachete() {
        super(4, 4);
        left = getImage();
        right = new GreenfootImage(left);
        right.mirrorHorizontally();
        movingRight = true;
        bounces = 0;
    }
    public BoomerangMachete(boolean movingRight) {
        this();
        this.movingRight = movingRight;
    }
    public void act() {
        if(movingRight) {
            this.setImage(right);
            this.setLocation(this.getX() + 10, this.getY());
        }
        else {
            this.setImage(left);
            this.setLocation(this.getX() - 10, this.getY());
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
            intersects = false;
        }
        if(bounces == 1 && this.isTouching(Balthazar.class)) {
            getWorld().removeObject(this); 
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
}