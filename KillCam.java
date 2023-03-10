import greenfoot.*;
import java.util.*;
public class KillCam extends World {
    private ArrayList<Actor> actors;
    private ArrayList<Integer> posX, posY, rotation;
    private int counter;
    public KillCam(ArrayList<Actor> actors, ArrayList<Integer> posX, ArrayList<Integer> posY, 
        ArrayList<Integer> rotation) {    
        super(1200, 700, 1); 
        this.actors = actors;
        this.posX = posX;
        this.posY = posY;
        this.rotation = rotation;
        counter = 0;
    }
    public void act() {
        Greenfoot.playSound("killcam.mp3");
        for(int i = 0; i < actors.size(); i++) {
            actors.get(i).setLocation(posX.get(counter), posY.get(counter));
            actors.get(i).setRotation(rotation.get(counter));
        }
        counter++;
        if(counter == posX.size()){
            Greenfoot.setWorld(new GruHouse());
        }
    }
}
