import greenfoot.*;
import java.util.*;
public abstract class Stage extends World {
    private Player player;
    private CPU cpu;
    private Platform topPlatform;
    private Platform leftPlatform;
    private Platform rightPlatform;
    public Stage() {
        super(1200, 700, 1);
        prepareLevel();
    }
    private void prepareLevel() {
        player = new Balthazar();
        cpu = new BalthazarCPU();
        this.addObject(player, 200, this.getHeight() - 150);
        this.addObject(cpu, 1000, this.getHeight() - 175);
        this.setPaintOrder(Actor.class, Weapon.class, Ability.class, Player.class);
    }
}