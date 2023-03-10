import greenfoot.*;
public class Stage extends World {
    private Player player;
    private Player cpu;
    public Stage() {    
        super(1200, 700, 1);
        this.setPaintOrder(Balthazar.class, BubbleGum.class, 
            ElMacho.class, TortillaChip.class, GuacamoleTortillaChip.class);
        
        player = new Balthazar();
        cpu = new Vector();
        this.addObject(player, 200, this.getHeight() - 200);
        this.addObject(cpu, 1000, this.getHeight() - 200);
    }
}