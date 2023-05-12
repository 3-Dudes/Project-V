import greenfoot.*;
public class FlyingV extends UltimateAbility {
    private static GreenfootImage left;
    private static GreenfootImage right;
    private boolean hitEdge;
    private Vector v;
    private int bombCount;
    private int bombDelay;
    private int yOffset;
    private int startY;
    public FlyingV(Vector v) {
        hitEdge = false;
        this.v = v;
        bombCount = 0;
        bombDelay = 15;
        yOffset = 10;
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        right = getImage();
        right.scale(right.getWidth() / 3, right.getHeight() / 3);
        left = new GreenfootImage(right);
        this.setRotation(135);
        left.mirrorHorizontally();
        this.setImage(left);
        this.setLocation(this.getX(), 100);
        startY = this.getY();
    }
    public void act() {
        bombCount++;
        if(bombCount == bombDelay) {
            getWorld().addObject(new Bomb(), this.getX(), startY + yOffset);
            bombCount = 0;
        }
        if(hitEdge) {
            this.setLocation(this.getX() + 7, this.getY() - 10);
            yOffset -= 15;
        }
        else {
            this.setLocation(this.getX() + 7, this.getY() + 10);
            yOffset += 15;
        }
        if(getY() >= 450) {
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