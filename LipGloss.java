import greenfoot.*;
public class LipGloss extends Weapon {
    private int tracker;
    private int ammo;
    public static GreenfootImage left;
    public static GreenfootImage right;
    private boolean isRight;
    public LipGloss(boolean isRight) {
        super(null, null);
        tracker = 0;
        ammo = 7;
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 3);
        this.isRight = isRight;
    }
    public LipGloss() {
        this(true);
    }
    public void act() {
        move();
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
        }
        detectCollision("Lucy", 3);
    }
    public void move() {
        switch(tracker) {
            case 5:
                this.setRotation(90);
                break;
            case 10:
                this.setRotation(180);
                break;
            case 15:
                this.setRotation(270);
                break;
            case 20:
                this.setRotation(360);
                break;
            case 25:
                tracker = 0;
                this.setRotation(0);
                break;
        }
        tracker++;
        if(isRight) {
            this.setLocation(this.getX() + 10, this.getY());    
        }
        else {
            this.setLocation(this.getX() - 10, this.getY());
        }
    }
    @Override
    public void detectCollision(String name, int damage) {
        super.detectCollision(name, damage);
        if(getWorld() != null) {
            Player player = (Player) getOneIntersectingObject(Player.class);
            if(player != null && !(player.getClass().getName().equals(name))) {
                if(isHittingCenter(player)) {
                    getWorld().removeObject(this);
                }
            }
        }
    }
    private boolean isHittingCenter(Player p) {
        return Math.abs(p.getX() - this.getX()) >= 10;
    }
}