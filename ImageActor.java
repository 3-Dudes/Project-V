import greenfoot.*;
import java.util.*;
public class ImageActor extends Actor {
    private GreenfootImage img;
    private StageButton button;
    private boolean mouseHovered;
    private boolean playerPick;
    private boolean cpuPick;
    private boolean playerHasPicked;
    private boolean cpuHasPicked;
    private boolean mouseClicked;
    private Player playerSelected;
    private Player cpuSelected;
    private String text;
    private int xOffset;
    private int yOffset;
    private Stage st;
    private Player p;
    public ImageActor(GreenfootImage img, String text, int xOffset, int yOffset) {
        this.img = img;
        this.text = text;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.st = st;
        this.setImage(img);
        mouseHovered = false;
        playerPick = true;
        mouseClicked = false;
        cpuPick = false;
    }
    public ImageActor(GreenfootImage img, String text, int xOffset, int yOffset,
        Stage st) {
        this(img, text, xOffset, yOffset);
        this.st = st;
    }
    public Stage getStage(){
        return this.st;
    }
    public ImageActor(GreenfootImage img, String text, int xOffset, 
        int yOffset, Player p) {
        this(img, text, xOffset, yOffset);
        this.p = p;
    }
    public void act() {
        if(isMouseOver() && !mouseHovered) {
            button = new StageButton(text, xOffset, yOffset);
            getWorld().addObject(button, this.getX(), this.getY() + 100);
            mouseHovered = true;
        }
        if(!isMouseOver() && mouseHovered) {
            getWorld().removeObject(button);
            mouseHovered = false;
        }
        if(Greenfoot.mouseClicked(this) && !mouseClicked) {
            mouseClicked = true;
            if(st != null) {
                Greenfoot.setWorld(st); 
                mouseClicked = false;
            }
            if(p != null) {
                if(playerPick) {
                    String pText = p.getClass().getName();
                        switch(pText) {
                            case "ElMacho":
                                playerSelected = new ElMacho();
                                mouseClicked = false;
                                break;
                            case "Balthazar":
                                playerSelected = new Balthazar();
                                mouseClicked = false;
                                break;
                        }
                    playerPick = false;
                    playerHasPicked = true;
                    cpuPick = true;
                }
                if(cpuPick) {
                    String text = "";
                    if(playerSelected.getClass().getName().equals("ElMacho")) {
                        text = "Balthazar";
                    }
                    else {
                        text = "ElMacho";
                    }
                    switch(text) {
                            case "ElMacho":
                                cpuSelected = new ElMacho();
                                mouseClicked = false;
                                break;
                            case "Balthazar":
                                cpuSelected = new Balthazar();
                                mouseClicked = false;
                                break;
                    }
                        cpuPick = false;
                        cpuHasPicked = true;
                }
            }    
        }
        if(playerHasPicked && cpuHasPicked) {
            Greenfoot.setWorld(new StageSelect(playerSelected, cpuSelected));
        }
    }
    public boolean isMouseOver() {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null) {
            int mx = m.getX();
            int my = m.getY();
            return getX() - getImage().getWidth()/2 < mx && getX() 
                + getImage().getWidth()/2 > mx && getY() - getImage().getHeight()/2 
            < my && getY() + getImage().getHeight()/2 > my;
        }
        return false;
    }
    public ImageActor getPlayerSelected() {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null) {
            return (ImageActor) m.getActor();
        }
        return null;
    }
}