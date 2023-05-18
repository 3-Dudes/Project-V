import greenfoot.*;
import java.util.*;
public class CharacterSelect extends World {
    private static List<ImageActor> players;
    private int x;
    public CharacterSelect() {    
        super(1200, 700, 1);  
        players = new ArrayList<ImageActor>();
        addPlayers();
        makeScreen();
    }

    private void makeScreen() {
        GreenfootImage img = getBackground();
        img.setColor(Color.BLACK);
        img.fill();
        this.setBackground(img);

        GreenfootImage text = new GreenfootImage("Select Your Character", 60, 
                Color.ORANGE, null);
        getBackground().drawImage(text, 350, 50);

        addPlayers();

        for(ImageActor ia : players) {
            this.addObject(ia, x, 300);
        }
    }
    public static void addPlayers() {
        players.add(new ImageActor(new ElMacho().getImage(), "El Macho", -30, -30, 
                new ElMacho()));
    }
}