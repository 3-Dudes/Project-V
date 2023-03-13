import greenfoot.*;
public class Shield extends Actor
{
    public Shield() {
        GreenfootImage img = this.getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
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
    public double distance(Actor a, Actor b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) 
            + Math.pow(a.getY() - b.getY(), 2));
    }
    public void act() {
        Actor a = this.findNearestActor();
        if(a != null) {
            this.setLocation(a.getX(), a.getY());
        }
    }    
}