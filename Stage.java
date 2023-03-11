import greenfoot.*;
public class Stage extends World {
    private Player player;
    private Player cpu;
    private HealthBar playerBar;
    private HealthBar cpuBar;
    public Stage() {
        super(1200, 700, 1);
        playerBar = new HealthBar();
        cpuBar = new HealthBar();
        this.setPaintOrder(Shield.class, BubbleGum.class, Balthazar.class,
            ElMacho.class, TortillaChip.class, GuacamoleTortillaChip.class);
        
        player = new ElMacho();
        this.addObject(player, 200, this.getHeight() - 150);
        this.addObject(playerBar, player.getX(), 100);
    }
}