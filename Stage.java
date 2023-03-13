import greenfoot.*;
public class Stage extends World {
    private Player player;
    private Player cpu;
    public Stage() {
        super(1200, 700, 1);
        this.setPaintOrder(Shield.class, BubbleGum.class, Balthazar.class,
            ElMacho.class, TortillaChip.class, GuacamoleTortillaChip.class);
        
        player = new ElMacho();
        this.addObject(player, 200, this.getHeight() - 150);
        this.addObject(player.getHealthBar(), player.getX(), 100);
    }
}