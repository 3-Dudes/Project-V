import greenfoot.*;
public abstract class Weapon extends Actor {
    public void act() {
        //move();
        move1();
        checkEdges();
    }
    public double distance(Actor a, Actor b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) 
            + Math.pow(a.getY() - b.getY(), 2));
    }
    public Actor findNearestActor() {
        Actor nearest = null;
        java.util.List<Actor> inRange = this.getObjectsInRange(2, Actor.class);
        double nearestDistance = Double.MAX_VALUE;
        for(Actor a : inRange) {
            if(a != this) {
                double distance = this.distance(this, a);
                if(distance < nearestDistance) {
                    nearest = a;
                    nearestDistance = distance;
                }
            }
        }
        return nearest;
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
    public void move1() {
        Actor nearest = findNearestActor();
        if(Greenfoot.isKeyDown("W")) {
            this.setLocation(nearest.getX(), nearest.getY() - 5);
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