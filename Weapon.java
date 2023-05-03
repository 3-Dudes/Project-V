import greenfoot.*;
public abstract class Weapon extends Actor {
    protected boolean intersects;
    protected Player p;
    private int spaceX;
    private int spaceY;
    private static GreenfootImage left;
    private static GreenfootImage right;
    public Weapon(Player p, int spaceX, int spaceY, Integer factor) {
        this.intersects = false;
        this.p = p;
        this.spaceX = spaceX;
        this.spaceY = spaceY;
        right = getImage();
        if(factor != null) {
            right.scale(right.getWidth() / factor, right.getWidth() / factor);    
        }
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
    }
    public Weapon() {
        this.intersects = false;
    }
    public void act() {
        if(p != null) {
            if(!p.facingRight()) {
                this.setLocation(p.getX() - spaceX, p.getY() - spaceY);
                this.setImage(left);
            }   
            else {
                this.setLocation(p.getX() + spaceX, p.getY() - spaceY);
                this.setImage(right);
            }
            if(this.isAtEdge()) {
                if(this.getX() == 0) {
                    p.setLocation(getWorld().getWidth() - 1, p.getY());
                }
                else if(this.getX() == getWorld().getWidth() - 1) {
                    p.setLocation(0, p.getY());
                }
            }
        }
    }
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            Player player = (Player) this.getOneIntersectingObject(Player.class);
            if(player != null && !(player instanceof ElMacho) && !intersects) {
                player.decreaseHealth(damage);
                intersects = true;
            }
        }
    }
}