import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Stock extends Mode
{
    private int lives1;
    private int lives2;
    private boolean win;
    //private Character p1=new Character(char1);
    //private Character p1=new Character(char2);
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