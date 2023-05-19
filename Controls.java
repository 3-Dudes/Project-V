import greenfoot.*;
public class Controls extends World {
    private ControlsButton button;
    public Controls()
    {    
        super(1200, 700, 1);
        button = new ControlsButton();
        this.addObject(button, 650, 500);
        makeScreen();
    }
    private void makeScreen() {
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();
        GreenfootImage controls = new GreenfootImage("Controls", 60, Color.ORANGE, null);
        bg.drawImage(controls, 550, 55);
        
        GreenfootImage text = new GreenfootImage("Player 1", 30, Color.ORANGE, null);
        GreenfootImage text1 = new GreenfootImage("C - Ability 1", 30, Color.ORANGE, null);
        GreenfootImage text2 = new GreenfootImage("Q - Ability 2", 30, Color.ORANGE, null);
        GreenfootImage text3 = new GreenfootImage("E - Ability 3", 30, Color.ORANGE, null);
        GreenfootImage text4 = new GreenfootImage("X - Ability 4", 30, Color.ORANGE, null);
        GreenfootImage text5 = new GreenfootImage("B - Primary Fire", 30, Color.ORANGE, null);
        GreenfootImage text6 = new GreenfootImage("V - Alt Fire", 30, Color.ORANGE, null);
        GreenfootImage move = new GreenfootImage("A and D - Move Left/Right", 30, 
            Color.ORANGE, null);
        GreenfootImage jump = new GreenfootImage("W - Jump", 30, 
            Color.ORANGE, null);
        
        GreenfootImage text7 = new GreenfootImage("Player 2", 30, Color.ORANGE, null);
        GreenfootImage text8 = new GreenfootImage("L - Ability 1", 30, Color.ORANGE, null);
        GreenfootImage text9 = new GreenfootImage("O - Ability 2", 30, Color.ORANGE, null);
        GreenfootImage text10 = new GreenfootImage("P - Ability 3", 30, Color.ORANGE, null);
        GreenfootImage text11 = new GreenfootImage("K - Ability 4", 30, Color.ORANGE, null);
        GreenfootImage text12 = new GreenfootImage("N - Primary Fire", 30, Color.ORANGE, null);
        GreenfootImage text13 = new GreenfootImage("M - Alt Fire", 30, Color.ORANGE, null);
        GreenfootImage move1 = new GreenfootImage("LEFT and RIGHT - Move Left/Right", 30, 
            Color.ORANGE, null);
        GreenfootImage jump1 = new GreenfootImage("UP - Jump", 30, 
            Color.ORANGE, null);
        
        bg.drawImage(text, 300, 150);
        bg.drawImage(text1, 300, 180);
        bg.drawImage(text2, 300, 210);
        bg.drawImage(text3, 300, 240);
        bg.drawImage(text4, 300, 270);
        bg.drawImage(text5, 300, 300);
        bg.drawImage(text6, 300, 330);
        bg.drawImage(move, 300, 360);
        bg.drawImage(jump, 300, 390);
        
        bg.drawImage(text7, 800, 150);
        bg.drawImage(text8, 800, 180);
        bg.drawImage(text9, 800, 210);
        bg.drawImage(text10, 800, 240);
        bg.drawImage(text11, 800, 270);
        bg.drawImage(text12, 800, 300);
        bg.drawImage(text13, 800, 330);
        bg.drawImage(move1, 800, 360);
        bg.drawImage(jump1, 800, 390);
    }
}