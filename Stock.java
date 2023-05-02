import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Stock extends Mode
{
    private int lives1;
    private int lives2;
    private boolean win;
    public Stock() {
        //super(new Player(), new Player());
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
    }
}
