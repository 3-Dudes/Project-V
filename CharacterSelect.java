import greenfoot.*;
import java.util.*;
public class CharacterSelect extends World {
    public static List<Player> players;
    public CharacterSelect() {    
        super(1200, 700, 1);
        players = new ArrayList<Player>();  
    }
    public static void addPlayers() {
        players.add(new Balthazar());
        players.add(new ElMacho());
        players.add(new Lucy());
    }
}