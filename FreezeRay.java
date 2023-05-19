import greenfoot.*;
import java.util.List;
public class FreezeRay extends Ability {
    private int duration;
    private static GreenfootImage left;
    private static GreenfootImage right;
    private Gru g;
    private boolean spawnedIn;
    private GreenfootSound sleigh = new GreenfootSound("sleigh_bells-7-22-12-edit-99843.mp3");
    private GreenfootSound laser = new GreenfootSound("blaster-2-81267.mp3");
    private FreezeRayBlast ammo;
    private boolean isFacingRight;
    public FreezeRay() {
        super(1000, 10);
        isFacingRight = false;
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
        if(g.facingRight()) {
            getWorld().addObject(ammo, g.getX() + 100, g.getY() - 60);
        } 
        else {
            getWorld().addObject(ammo, g.getX() - 100, g.getY() - 60);
        }
    }
    private void removeFreezeBlocks() {
        List<FreezeBlock> freezeBlocks = getWorld().getObjects(FreezeBlock.class);
        for (FreezeBlock fb : freezeBlocks) {
            getWorld().removeObject(fb);
        }
    }
    @Override
    public void act() {
        if(this.exists()) {
            spawnedIn = true;
        }
        if(spawnedIn) {
            sleigh.play();
            laser.play();
        }
        if(g.facingRight()) {
            this.setImage(right);
            isFacingRight = true;
            this.setLocation(g.getX() + 100, g.getY() - 60);
        } 
        else {
            this.setImage(left);
            isFacingRight = false;
            this.setLocation(g.getX() - 100, g.getY() - 60);
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
            if(p != null && !intersects && !(p instanceof Gru)) {
                p.decreaseHealth(getDamage());
                FreezeBlock freezedP = new FreezeBlock(p);
                getWorld().addObject(freezedP, p.getX(), p.getY());
                getWorld().setPaintOrder(Weapon.class, Actor.class, Player.class, FreezeBlock.class);
                intersects = true;
                p.canMove = false;
                p.canCast = false;
            }
        }
    }
    public boolean facingRight() {
        return isFacingRight;
    }
    public boolean exists() {
        return getWorld() != null;
    }
}