import greenfoot.*;
public class Stage extends World {
    private Player player;
    private Player cpu;
    public Stage() {
        super(1200, 700, 1);
        prepareLevel();
    }
    private void prepareLevel() {
        player = new Balthazar();
        cpu = new ElMacho();
        this.addObject(player, 200, this.getHeight() - 150);
        this.addObject(player.getHealthBar(), player.getX(), 200);
        this.addObject(cpu, 1000, this.getHeight() - 175);
        this.addObject(cpu.getHealthBar(), cpu.getX(), 200);
        this.setPaintOrder(Ability.class, Weapon.class, Player.class);
    }
}