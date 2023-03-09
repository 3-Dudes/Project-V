import greenfoot.*;
public class Space extends World {
    private Vector vector;
    private HealthBar bossBar;
    private HealthBar playerBar;
    
    public Space() {
        super(1200, 700, 1); 
        prepare();
    }
    
    private void prepare() {
        vector = new Vector();
        addObject(vector, 1051, 280);
        addObject(bossBar, 1050, 70);
        addObject(playerBar, 150, bossBar.getY());
        
        //PiranhaGun piranhaGun = new PiranhaGun();
        //addObject(piranhaGun, 970, 270);
    }
}
