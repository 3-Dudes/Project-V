import greenfoot.*;
import java.util.*;
public class Stage extends World {
    private Player player;
    private Player cpu;
    private Platform topPlatform;
    private Platform leftPlatform;
    private Platform rightPlatform;
    public Stage() {
        super(1200, 700, 1);
        prepareLevel();
    }
    private void prepareLevel() {
        player = new ElMacho();
        cpu = new Balthazar();
        //this.addObject(player, 200, this.getHeight() - 150);
        //this.addObject(cpu, 1000, this.getHeight() - 175);
        this.setPaintOrder(Ability.class, Weapon.class, Player.class);
        addPlatforms();
    }
    private void addPlatforms() {
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(4);
        sequence.add(3);
        List<Integer> sequence2 = new ArrayList<Integer>();
        sequence2.add(1); sequence2.add(3); sequence2.add(2); sequence2.add(4);
        topPlatform = new Platform(true, true, sequence);
        leftPlatform = new Platform(true, false, sequence2);
        this.addObject(topPlatform, 600, 200);
        this.addObject(leftPlatform, 300, 500);
    }
}