import greenfoot.*;
public class Stage extends World {
    private Player player;
    private Player cpu;
    public Stage() {    
        super(1200, 700, 1);
        this.setPaintOrder(Player.class);
    }
}
