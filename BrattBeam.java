import greenfoot.*;
public class BrattBeam extends Weapon {
    private GreenfootImage beam;
    private Color hotPink;
    private BalthazarBot bb;
    public BrattBeam() {
        super(1, 1);
        beam = new GreenfootImage(600, 25);
        hotPink = new Color(255, 102, 178);
        beam.setColor(hotPink);
        beam.fill();
        this.setImage(beam);
    }
    public BrattBeam(BalthazarBot bb) {
        this();
        this.bb = bb;
    }
    @Override
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        this.setRotation(10);
    }
    public void act() {
        detectCollision("Balthazar", 2);
        if(bb != null) {
            this.setLocation(bb.getX() + 270, bb.getY() - 95);    
        }
    }
    @Override
    public void detectCollision(String name, int damage) {
        if(getWorld() != null) {
            Player p = (Player) getOneIntersectingObject(Player.class);
            if(p != null && !(p.getClass().getName().equals(name))) {
                p.decreaseHealth(damage);
            }
        }
    }
}