import greenfoot.*;
import java.util.*;
public class StageSelect extends World {
    private static List<ImageActor> stages;
    private int xOffset;
    private Player player;
    private Player cpu;
    public StageSelect(Player player, Player cpu) {
        super(1200, 700, 1);  
        stages = new ArrayList<ImageActor>();
        this.player = player;
        this.cpu = cpu;
        xOffset = 170;
        makeScreen();
        addStages();
        for(ImageActor ia : stages) {
            this.addObject(ia, xOffset, 225);
            xOffset += 300;
        }
    }
    private void makeScreen() {
        GreenfootImage img = getBackground();
        img.setColor(Color.BLACK);
        img.fill();
        this.setBackground(img);
        
        GreenfootImage text = new GreenfootImage("Select Your Stage", 60, Color.ORANGE, null);
        getBackground().drawImage(text, 400, 50);
    }
    public void addStages() {
        stages.add(new ImageActor(new BankOfEvil(player, cpu).getBackground(), 
            "Bank Of Evil", -70, -30, new BankOfEvil(player, cpu)));
        stages.add(new ImageActor(new ElMachoLair(player, cpu).getBackground(), 
            "El Macho's Lair", -80, -30, new ElMachoLair(player, cpu)));
        stages.add(new ImageActor(new GruHouse(player, cpu).getBackground(), "Gru's House",
            -70, -30, new GruHouse(player, cpu)));
        stages.add(new ImageActor(new GruLair(player, cpu).getBackground(), "Gru's Lair",
            -55, -30, new GruLair(player, cpu)));
        for(ImageActor ia : stages) {
            scale(ia.getImage());
        }
    }
    public static void scale(GreenfootImage img) {
        img.scale(img.getWidth() / 6, img.getHeight() / 6);
    }
}