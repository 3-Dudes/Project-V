import greenfoot.*;
import java.util.*;
public class TortillaChip extends Weapon {
    private static int damage = 10;
    public static GreenfootImage rightImg;
    public static GreenfootImage leftImg;
    private boolean right;
    private ElMacho e;
    
    public TortillaChip(ElMacho e) {
        this(false, e);
    }
    
    public TortillaChip(boolean right, ElMacho e) {
        super(e);
        this.e = e;
        this.right = right;
        rightImg = this.getImage();
        rightImg.scale(rightImg.getWidth() / 7, rightImg.getHeight() / 7);
        rightImg.mirrorHorizontally();
        leftImg = new GreenfootImage(rightImg);
        leftImg.mirrorHorizontally();
        if(!right) {
            this.setImage(leftImg);
        }
    }

    public void act() {
        moveChip();
        if(this.isTouching(BubbleGum.class)) {
            this.removeTouching(BubbleGum.class);
        }
        detectCollision("ElMacho", damage);
    }
    
    private void moveChip() {
        if(e.usedUlt) {
            this.setRotation(90);
            this.setLocation(this.getX(), this.getY() + 8);
            clear();
            e.ultDur++;
            if(e.ultDur == 6000) {
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
                e.usedUlt = false;
                e.ultDur = 0;
            }
        }
        else {
            this.setRotation(0);
            if(right) {
                this.setLocation(this.getX() + 8, this.getY());
            }
            else {
                this.setLocation(this.getX() - 8, this.getY());
            }
            if(this != null) {
                super.clear();   
            }
        }
    }

    @Override
    protected void clear() {
        if(this.isAtEdge()) {
            this.setLocation(this.getX(), 0);
        }
    }
}