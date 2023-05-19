import greenfoot.*;
public class WrestlingChamp extends Ability  {
    private static GreenfootImage flyRight;
    private static GreenfootImage flyLeft;
    private ElMacho macho;
    
    public WrestlingChamp() {
        super(1400, 40);
        this.setRotation(90);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        flyRight = new GreenfootImage(getImage());
        flyLeft = new GreenfootImage(flyRight);
        flyLeft.mirrorVertically();
    }
    public WrestlingChamp(ElMacho macho) {
        this();
        this.macho = macho;
    }
    
    @Override
    public void act() {
        if(macho.facingRight()) {
            this.setImage(flyRight);
            this.setLocation(this.getX() + 30, this.getY());
        }
        else {
            this.setImage(flyLeft);
            this.setLocation(this.getX() - 30, this.getY());    
        }
        detectCollision("ElMacho");
    }
    @Override
    public void detectCollision(String name) {
        if(getWorld() != null) {
            Player hitPlayer = (Player) this.getOneIntersectingObject(Player.class);
            if(hitPlayer != null && !hitPlayer.getClass().getName().equals(name)
                && !intersects) {
                hitPlayer.decreaseHealth(this.getDamage());
                intersects = true;
                hitPlayer.canMove = false;
                hitPlayer.canCast = false;
                hitPlayer.setRotation(90);
            } 
        }
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
            macho.setRotation(0);
            macho.canMove = true;
            macho.canCast = true;
            isFinished = true;
        }
    }
}