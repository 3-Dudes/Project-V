import greenfoot.*;

public class FlyingV extends UltimateAbility {
    private static GreenfootImage left;
    private static GreenfootImage right;
    private boolean hitEdge;
    private Vector v;
    private int yOffset;
    private int startY;
    private int bombDelay;
    private int bombCounter;
    

    public FlyingV(Vector v) {
        hitEdge = false;
        this.v = v;
        yOffset = 10;
        bombDelay = 10;
        bombCounter = bombDelay;
        right = getImage();
        right.scale(right.getWidth() / 3, right.getHeight() / 3);
        left = new GreenfootImage(right);
        left.mirrorHorizontally();
        this.setImage(left);
    }

    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        this.setRotation(135);
        startY = this.getY();
        this.setLocation(this.getX(), 100);
    }

    public void act() {
        if(bombCounter >= bombDelay) {
            bomb.reset(this.getX(), startY + yOffset);
            getWorld().addObject(bomb, this.getX(), startY + yOffset);
            bombCounter = 0;
        } 
        else {
            bombCounter++;
        }
        if(hitEdge) {
            this.setLocation(this.getX() + 7, this.getY() - 10);
            yOffset -= 15;
        } 
        else {
            this.setLocation(this.getX() + 7, this.getY() + 10);
            yOffset += 15;
        }
        if(this.getY() >= 450) {
            this.setRotation(50);
            hitEdge = true;
        }
        if(this.getY() <= 100) {
            isFinished = true;
        }
        if(isFinished()) {
            getWorld().removeObject(this);
            setCharge(0);
            v.canMove = true;
            v.canCast = true;
        }
    }
}
