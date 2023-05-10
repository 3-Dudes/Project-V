import greenfoot.*;
import java.util.*;
public class Bomb extends Actor {
    private GreenfootImage explosion;
    private Vector v;
    public Bomb(Vector v) {
        GreenfootImage img = getImage();
        this.v = v;
        img.scale(img.getWidth() / 6, img.getHeight() / 6);
        explosion = new GreenfootImage("bomb_explode.png");
        explosion.scale(explosion.getWidth() / 3, explosion.getHeight() / 3);
    }
    public void act() {
        this.setLocation(v.getX(), v.getY());
        if(this.isTouching(Player.class) || this.isAtEdge()) {
            this.setImage(explosion);
        }
    }    
}
