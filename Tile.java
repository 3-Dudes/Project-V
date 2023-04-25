import greenfoot.*;
import java.util.*;
public class Tile extends Ability {
    private static List<GreenfootImage> tiles;
    private static GreenfootImage redTile;
    private static GreenfootImage blueTile;
    private static GreenfootImage greenTile;
    private static GreenfootImage yellowTile;
    
    private int tileSelectDuration;
    private int moveDuration;
    private ElMacho macho;
    private boolean hasSelected;
    private Random rand;
    private int stopPoint;
    private int effectDuration;
    
    public Tile(ElMacho macho) {
        super(4500, 0);
        yellowTile = new GreenfootImage("yellowtile.png");
        blueTile = new GreenfootImage("bluetile.png");
        redTile = new GreenfootImage("redtile.png");
        greenTile = new GreenfootImage("greentile.png");
        tiles = new ArrayList<GreenfootImage>();
        this.setImage(yellowTile);
        tileSelectDuration = 0;
        effectDuration = 0;
        this.macho = macho;
        hasSelected = false;
        rand = new Random();
        addTiles();
    }
    private void addTiles() {
        tiles.add(blueTile);
        tiles.add(redTile);
        tiles.add(greenTile);
        tiles.add(yellowTile);
        for(GreenfootImage img : tiles) {
            scale(img);
        }
    }
    public static void scale(GreenfootImage img) {
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
    }
    public void act() {
        changeTileColor();
        this.setLocation(macho.getX(), this.getY());
        stopPoint = rand.nextInt(21) * 2;
        if(tileSelectDuration == stopPoint) {
            hasSelected = true;
            changeTileColor();
            if(getImage() == redTile) {
                
            }
            else if(getImage() == blueTile) {
                
            }
            else if(getImage() == greenTile) {
                
            }
            else if(getImage() == yellowTile) {
                detectCollision("ElMacho");
                macho.isEduardo = true;
            }
            moveDuration++;
        }
        if(!hasSelected) {
            tileSelectDuration += 2;   
        }
        if(moveDuration == 35) {
            getWorld().removeObject(this);
            moveDuration = 0;
            isFinished = true;
            if(macho.isEduardo) {
                macho.isEduardo = false;
            }
        }
    }
    public boolean hasSelected() {
        return hasSelected;
    }
    private void changeTileColor() {
        if(tileSelectDuration == 10) {
            this.setImage(redTile);    
        }
        if(tileSelectDuration == 20) {
            this.setImage(blueTile);
        }
        if(tileSelectDuration == 30) {
            this.setImage(greenTile);
        }
        if(tileSelectDuration == 40) {
            this.setImage(yellowTile);
            tileSelectDuration = 0;
        }
    }
    private void performAfterEffect() {
        effectDuration++;
        if(effectDuration >= 1 && effectDuration < 50) {
            hitPlayer.decreaseHealth(1);
        }
        if(effectDuration == 50) {
            effectDuration = 0;
        }
    }
}