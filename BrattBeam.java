import greenfoot.*;
public class BrattBeam extends Weapon {
    private GreenfootImage beam;
    private Color hotPink;
    private BalthazarBot bb;
    private boolean spawnedIn;
    private GreenfootSound bean = new GreenfootSound("blaster-2-81267.mp3");
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
        this.setRotation(25);
    }
    public void act() {
        if(this.exists()) {
            spawnedIn = true;
        }
        if(spawnedIn) {
            bean.play();
        }
        detectCollision("Balthazar", 2);
        if(bb != null) {
            this.setLocation(bb.getX() + 270, bb.getY() - 25);    
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
    public boolean exists() {
        return getWorld() != null;
    }
}