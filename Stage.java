import greenfoot.*;
import java.util.*;
public abstract class Stage extends World {
    private Player player;
    private Player cpu;
    private Platform topPlatform;
    private Platform leftPlatform;
    private Platform rightPlatform;
    public Stage(Player player, Player cpu) {
        super(1200, 700, 1);
        this.player = player;
        this.cpu = cpu;
        prepareLevel();
    }
    private void prepareLevel() {
        this.addObject(player, 200, 550);
        this.addObject(cpu, 1000, 550);
        this.setPaintOrder(Weapon.class, 
            Ability.class, Actor.class, Player.class);
        //addPlatforms();
    }   
    private void addPlatforms() {
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(4);
        sequence.add(3);
        List<Integer> sequence2 = new ArrayList<Integer>();
        sequence2.add(1); sequence2.add(3); sequence2.add(2); sequence2.add(4);
        topPlatform = new Platform(true, true, sequence);
        leftPlatform = new Platform(50, 200, true, false, sequence2);
        //1 is up, 2 is lefdown, 3 is left, 4 is right
        List<Integer> sequence3 = new ArrayList<Integer>();
        sequence3.add(1); sequence3.add(4); sequence3.add(3); sequence3.add(2);
        rightPlatform = new Platform(true, false, sequence3);
        this.addObject(topPlatform, 600, 200);
        this.addObject(leftPlatform, 300, 500);
        this.addObject(rightPlatform, 900, 500);
    }
}