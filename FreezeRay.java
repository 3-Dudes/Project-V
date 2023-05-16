import greenfoot.*;
import java.util.List;
public class FreezeRay extends Ability {
    private int duration;
    private static GreenfootImage left;
    private static GreenfootImage right;
    private boolean movingRight;
    private Gru g;
    private FreezeRayBlast ammo;
    public FreezeRay() {
        super(1000, 10);
        duration = 0;
        left = getImage();
        left.scale(left.getWidth() / 2, left.getHeight() / 2);
        right = new GreenfootImage(getImage());
        right.mirrorHorizontally();
        ammo = new FreezeRayBlast(this);
    }
    public FreezeRay(Gru g) {
        this();
        this.g = g;
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        getWorld().addObject(ammo, this.getX() + 185, this.getY() - 20);
    }
    @Override
    public void act() {
        this.setLocation(g.getX() + 100, g.getY());
        if(g.facingRight()) {
            this.setImage(right);
        }
        else {
            this.setImage(left);
        }
        if(duration == 500) {
            removeFreezeBlocks();
            isFinished = true;
            getWorld().removeObject(ammo);
            getWorld().removeObject(this);
            duration = 0;
        }
        detectCollision("Gru");
        duration++;
    }
    @Override
    public void detectCollision(String name) {
        if(getWorld() != null) {
            Player p = (Player) ammo.getOneIntersectingObject(Player.class);
            if(p != null && !intersects) {
                p.decreaseHealth(getDamage());
                FreezeBlock freezedP = new FreezeBlock(p);
                getWorld().addObject(freezedP, p.getX(), p.getY());
                getWorld().setPaintOrder(FreezeBlock.class, Player.class, Actor.class);
                intersects = true;
                p.canMove = false;
                p.canCast = false;
            }
        }
    }
    private void removeFreezeBlocks() {
        List<FreezeBlock> freezeBlocks = 
            getWorld().getObjects(FreezeBlock.class);
        for(FreezeBlock fb : freezeBlocks) {
            getWorld().removeObject(fb);
        }
    }
}