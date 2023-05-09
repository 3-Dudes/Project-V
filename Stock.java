import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Stock extends Mode
{
    private int lives1;
    private int lives2;
    private boolean win;
    private String n1;
    private String n2;
    private int factor1;
    private int factor2;
    
    private Player p1;
    private Player p2;
    public Stock(Player p1, Player p2) {
        this.p1=p1;
        this.p2=p2;
    }

    public void act(){
        //still need to add point counter
        if(lives1==0||lives2==0){
            if(lives1==0){
                playWinAnimation(p);
            }
            if(lives2==0){
                playWinAnimation(cpu);
            }
        }
        if(player.isDead()){
            lives1--;
            player.respawn();
        }
        if(cpu.isDead()){
            lives2--;
            cpu.respawn();
        }
    }
}