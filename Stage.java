import greenfoot.*;
public class Stage extends World {
    private Player player;
    private Player cpu;
    private Score score;
    public Stage() {
        super(1200, 700, 1);
        prepareLevel();
    }
    private void prepareLevel() {
        player = new ElMacho();
        cpu = new Balthazar();
        score = new Score(player.getPlayerScore(), cpu.getPlayerScore());
        this.addObject(player, 200, this.getHeight() - 150);
        this.addObject(cpu, 1000, this.getHeight() - 175);
        this.addObject(score, 600, player.getHealthBar().getY());
        this.setPaintOrder(Ability.class, Weapon.class, Player.class);
    }
}