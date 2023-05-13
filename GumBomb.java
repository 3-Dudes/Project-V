import greenfoot.*;
public class GumBomb extends Ability {
    private boolean isMoving;
    public GumBomb() {
        super(900, 10);
        isMoving = true;
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        this.setImage(img);
    }
    public void act() {
        moveGumBomb();
        if(this.isTouching(Player.class) && !this.isTouching(Balthazar.class)) {
            detectCollision("Balthazar");
            isMoving = false;
            pop();
        }
    }
    private void moveGumBomb() {
        if(isMoving) {
            this.setLocation(this.getX() + 10, this.getY());
            setDamage(getDamage() + 2);
        }
    }
    public void pop() {
        getWorld().removeObject(this);
    }
}