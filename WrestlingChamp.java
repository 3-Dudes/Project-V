import greenfoot.*;
public class WrestlingChamp extends Ability  {
    private static GreenfootImage flyRight;
    private static GreenfootImage flyLeft;
    private ElMacho macho;
    
    public WrestlingChamp(ElMacho macho) {
        super(1100, 40);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        this.macho = macho;
        makeSprites();
    }

    private void makeSprites() {
        this.setRotation(90);
        flyRight = new GreenfootImage(getImage());
        flyLeft = new GreenfootImage(flyRight);
        flyLeft.mirrorVertically();
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
            hitPlayer = (Player) this.getOneIntersectingObject(Player.class);
            if(hitPlayer != null && !hitPlayer.getClass().getName().equals(name)
                && !intersects) {
                hitPlayer.decreaseHealth(this.getDamage());
                intersects = true;
                hitPlayer.canMove = false;
                hitPlayer.setRotation(90);
            } 
        }
        if(this.isAtEdge()) {
            getWorld().removeObject(this);
            macho.setRotation(0);
            macho.setImage(ElMacho.elMacho);
            macho.canMove = true;
            isFinished = true;
        }
    }
}