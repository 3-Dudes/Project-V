import greenfoot.*;
import java.util.*;
public class StageSelect extends World {
    private static List<ImageActor> stages;
    private int xOffset;
    public StageSelect() {
        super(1200, 700, 1);  
        stages = new ArrayList<ImageActor>();
        xOffset = 170;
        makeScreen();
    }
    private void makeScreen() {
        GreenfootImage img = getBackground();
        img.setColor(Color.BLACK);
        img.fill();
        this.setBackground(img);
        
        GreenfootImage text = new GreenfootImage("Select Your Stage", 60, Color.ORANGE, null);
        getBackground().drawImage(text, 400, 50);
        addStages();
        for(ImageActor ia : stages) {
            this.addObject(ia, xOffset, 225);
            xOffset += 300;
        }
    }
    public static void addStages() {
        stages.add(new ImageActor(new BankOfEvil().getBackground(), 
            "Bank Of Evil", -70, -30, new BankOfEvil()));
        stages.add(new ImageActor(new ElMachoLair().getBackground(), 
            "El Macho's Lair", -80, -30, new ElMachoLair()));
        stages.add(new ImageActor(new GruHouse().getBackground(), "Gru's House",
            -70, -30, new GruHouse()));
        stages.add(new ImageActor(new GruLair().getBackground(), "Gru's Lair",
            -55, -30, new GruLair()));
        for(ImageActor ia : stages) {
            scale(ia.getImage());
        }
    }
    public static void scale(GreenfootImage img) {
        img.scale(img.getWidth() / 6, img.getHeight() / 6);
    }
}