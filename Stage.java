import greenfoot.*;
public class Stage extends World {
    private Player player;
    private Player cpu;
    public Stage() {
        super(1200, 700, 1);
        prepareLevel();
    }
    private void prepareLevel() {
        player = new Vector();
        cpu = new Balthazar();
        this.addObject(player, 200, this.getHeight() - 150);
        this.addObject(cpu, 1000, this.getHeight() - 175); //Balthazar is causing crash
        this.setPaintOrder(Ability.class, Fire.class, Weapon.class, Player.class);
    }
}