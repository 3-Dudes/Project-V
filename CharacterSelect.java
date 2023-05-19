import greenfoot.*;
import java.util.*;
public class CharacterSelect extends World {
    private static List<ImageActor> players;
    private static List<Player> avaPlayers;
    private int x;
    public CharacterSelect() {    
        super(1200, 700, 1);
        players = new ArrayList<ImageActor>();
        avaPlayers = new ArrayList<Player>();
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
            x += 400;
            this.addObject(ia, x, 300);
        }
    }
    public static void addPlayers() {
        players.add(new ImageActor(new ElMacho().getImage(), "El Macho", -60, -30, 
                new ElMacho()));
        players.add(new ImageActor(new Balthazar().getImage(), "Balthazar", -60, -30, 
                new Balthazar()));
                
        avaPlayers.add(new ElMacho());
        avaPlayers.add(new Balthazar());
        avaPlayers.add(new Gru());
        avaPlayers.add(new Lucy());
        avaPlayers.add(new Vector());
    }
    
    public static List<Player> getAvaPlayers() {
        return avaPlayers;
    }
}