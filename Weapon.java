import greenfoot.*;
public abstract class Weapon extends Actor {
    public void act() {
        move();
        checkEdges();
    }
    public void checkEdges() {
        if(this.isAtEdge()) {
            if(this.getX() == 0) {
                this.setLocation(getWorld().getWidth() - 1, getY());
            }
            else if(this.getX() == getWorld().getWidth() - 1) {
                this.setLocation(0, getY());
            }
            else if(this.getY() == 0) {
                this.setLocation(getX(), getWorld().getHeight() - 1);
            }
            else if(this.getY() == getWorld().getHeight() - 1) {
                this.setLocation(getX(), 0);
            }
        }
    }
    public void move() {
        if(Greenfoot.isKeyDown("W")) {
            this.setLocation(this.getX(), this.getY() - 5);
        }
        else if(Greenfoot.isKeyDown("A")) {
            this.setLocation(this.getX() - 5, this.getY());
        }
        if(Greenfoot.isKeyDown("S")) {
            this.setLocation(this.getX(), this.getY() + 5);
        }
        if(Greenfoot.isKeyDown("D")) {
            this.setLocation(this.getX() + 5, this.getY());
        }
    }
}