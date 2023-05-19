import greenfoot.*;
public class RedLaser extends Actor {
    private LaserRifle weapon;
    private boolean intersects;
    private boolean movingRight;
    private Gru g;
    public RedLaser(Gru g) {
        GreenfootImage img = getImage();
        this.weapon = weapon;
        this.intersects = false;
        this.g = g;
        if(g.facingRight()) {
            movingRight = true;    
        }
        else {
            movingRight = false;
        }
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
    }
    public void act() {
        if(movingRight) {
            this.setLocation(this.getX() + 10, this.getY());
        }
        else {
            this.setLocation(this.getX() - 10, this.getY());
        }
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
        if(!removedFromWorld(this)) {
            Player p = (Player) this.getOneIntersectingObject(Player.class);
            if(p != null && !intersects && !(p instanceof Gru)) {
                p.decreaseHealth(10);
                intersects = true;
            }    
        }
    }
    @Override
    public Actor getOneIntersectingObject(Class<?> cls) {
        return super.getOneIntersectingObject(cls);
    }
    public boolean removedFromWorld(Actor a) {
        return getWorld() == null;
    }
}