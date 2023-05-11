import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Menu extends World {
    private FlyingV_Start vectorStart;
    public Menu() {    
        super(1200, 700, 1);
        makeScreen();
        Greenfoot.start();
    }
    private void makeScreen() {
        GreenfootImage bg = new GreenfootImage(this.getWidth(), this.getHeight());
        bg.setColor(Color.BLACK);
        bg.fill();
        this.setBackground(bg);
        
        GreenfootImage header 
            = new GreenfootImage("Project-V", 100, Color.ORANGE, null);
        Font f = new Font("Cascadia Code", 100);
        header.setFont(f);
        bg.drawImage(header, 450, 50);
        
        GreenfootImage authors = new GreenfootImage("Anirudh Konidala, Krishna Trivedi" 
            + "\n" + "Noah Patterson, Alikhan Kanash", 40, Color.ORANGE, null);
        bg.drawImage(authors, 375, 465);
        
        vectorStart = new FlyingV_Start();
        vectorStart.setRotation(90);
        this.addObject(vectorStart, 100, getHeight() / 2);
        if(vectorStart.isRemoved()) {
            //spawn button
        }
    }
}