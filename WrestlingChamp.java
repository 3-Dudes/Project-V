import greenfoot.*;
public class WrestlingChamp extends Ability  {
    // instance variables - replace the example below with your own
    private boolean movingRight;
    private boolean removedFromWorld;
    private static GreenfootImage flyRight;
    private static GreenfootImage flyLeft;
    private ElMacho macho;
    
    public WrestlingChamp(boolean movingRight, ElMacho macho) {
        super(1000, 40);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        this.movingRight = movingRight;
        this.removedFromWorld = false;
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
        super.act();
        if(movingRight) {
            this.setImage(flyRight);
            this.setLocation(this.getX() + 20, this.getY());
        }
        else {
            this.setImage(flyLeft);
            this.setLocation(this.getX() - 20, this.getY());    
        }
        detectCollision("ElMacho");
    }
    @Override
    public void detectCollision(String name) {
        if(getWorld() != null) {
            Player p = (Player) this.getOneIntersectingObject(Player.class);   
            if(p != null && !p.getClass().getName().equals(name)) {
                p.decreaseHealth(this.getDamage());
                this.setRotation(0);
                removedFromWorld = true;
            }
            else {
                if(this.isAtEdge()) {
                    removedFromWorld = true;
                }
            }
        }
        if(removedFromWorld) {
            getWorld().removeObject(this);
            macho.setImage(macho.getRightImage());
        }
    }
}
