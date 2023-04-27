import greenfoot.*;
public abstract class Weapon extends Actor {
    protected boolean intersects;
    protected Player p;
    public Weapon(Player p) {
        this.intersects = false;
        this.p = p;
    }
    public Weapon() {
        this.intersects = false;
    }
    public void act() {
        if(p != null) {
            this.setLocation(p.getX(), p.getY());    
        }
    }
    public void checkEdges() {
        if(this.isAtEdge()) {
            if(this.getX() == 0) {
                this.setLocation(getWorld().getWidth() - 1, this.getY());
            }
            else if(this.getX() == getWorld().getWidth() - 1) {
                this.setLocation(0, this.getY());
            }
            else if(this.getY() == 0) {
                this.setLocation(this.getX(), getWorld().getHeight() - 1);
            }
            else if(this.getY() == getWorld().getHeight() - 1) {
                this.setLocation(this.getX(), 0);
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