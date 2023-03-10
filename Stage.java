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
        
        player = new Balthazar();
        cpu = new ElMacho();
        this.addObject(cpu, 200, this.getHeight() - 150);
        this.addObject(player, 1000, this.getHeight() - 150);
        this.addObject(cpuBar, cpu.getX(), 100);
    }
}