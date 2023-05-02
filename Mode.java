import greenfoot.*;
public abstract class Mode extends World {
    protected Player p;
    protected Player cpu;
    public Mode(Player p, Player cpu) {    
        super(1200, 700, 1); 
        this.p = p;
        this.cpu = cpu;
    }
    public void playWinAnimation(Player p){
        
    }
}