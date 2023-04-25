import greenfoot.*;
import java.util.*;
public class TortillaChip extends Weapon {
    private static int damage = 10;
    public static GreenfootImage rightImg;
    public static GreenfootImage leftImg;
    private boolean right;
    private ElMacho macho;
    private int bounces;
    private boolean shouldRemove;
    
    public TortillaChip(ElMacho macho) {
        this(false, macho);
    }
    
    public TortillaChip(boolean right, ElMacho macho) {
        super(macho);
        this.macho = macho;
        this.right = right;
        this.shouldRemove = false;
        rightImg = this.getImage();
        rightImg.scale(rightImg.getWidth() / 7, rightImg.getHeight() / 7);
        rightImg.mirrorHorizontally();
        leftImg = new GreenfootImage(rightImg);
        leftImg.mirrorHorizontally();
        bounces = 0;
        if(!right) {
            this.setImage(leftImg);
        }
    }

    public void act() {
        moveChip();
        BubbleGum bg = (BubbleGum) this.getOneIntersectingObject(BubbleGum.class);
        if(bg != null) {
            bg.pop();
            shouldRemove = true;
        }
        if(!macho.isEduardo) {
            detectCollision("ElMacho", damage);    
        }
        if(shouldRemove) {
            getWorld().removeObject(this);   
        }
    }
    
    private void moveChip() {
        if(macho.usedUlt) {
            this.setRotation(90);
            this.setLocation(this.getX(), this.getY() + 8);
            macho.ultDur++;
            if(this.isAtEdge()) {
                this.setLocation(this.getX(), 0);
            }
            if(macho.ultDur == 6000) {
                World curWorld = getWorld();
                List<TortillaChip> chips = curWorld.getObjects(TortillaChip.class);
                List<TortillaChip> chipsToRemove = new ArrayList<>();
                for(TortillaChip c : chips) {
                    if(c.getRotation() == 90) {
                        chipsToRemove.add(c);
                    }
                }
                for(TortillaChip c : chipsToRemove) {
                    curWorld.removeObject(c);
                }
                macho.usedUlt = false;
                macho.ultDur = 0;
            }
        }
        else {
            this.setRotation(0);
            if(this.isAtEdge()) {
                if(!macho.isEduardo) {
                    shouldRemove = true;    
                }
                /* else {
                    getImage().mirrorHorizontally();
                    right = !right;
                    bounces++;
                    if(this.intersects(macho)) {
                        macho.increaseHealth(damage);                                   
                    }
                } */
            }
            if(right) {
                this.setLocation(this.getX() + 8, this.getY());
            }
            else {
                this.setLocation(this.getX() - 8, this.getY());
            }
        }
    }
}