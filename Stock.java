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

    private Character p1=new Player(n1, factor1);
    private Character p2=new Player(n2, factor2);
    public Stock(Player p1, Player p2) {
        
    }

    public void act(){
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