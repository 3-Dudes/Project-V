import greenfoot.*;
import java.util.*;
public class TortillaChip extends Weapon {
    private static int damage = 10;
    public static GreenfootImage img;
    public static GreenfootImage left;
    private boolean right;
    private ElMacho e;
    public TortillaChip(boolean right, ElMacho e) {
        super(e);
        this.e = e;
        this.right = right;
        img = this.getImage();
        img.scale(img.getWidth() / 7, img.getHeight() / 7);
        img.mirrorHorizontally();
        left = new GreenfootImage(img);
        left.mirrorHorizontally();
        setImage(img);
        if(!right) {
            getImage().mirrorHorizontally();
        }
    }

    public TortillaChip(ElMacho e) {
        super(e);
        this.e = e;
        img = this.getImage();
        img.scale(img.getWidth() / 7, img.getHeight() / 7);
        img.mirrorHorizontally();
        setImage(img);
    }

    public void act() {
        moveChip();
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
            super.clear();
        }
    }

    @Override
    protected void clear() {
        if(this.isAtEdge()) {
            this.setLocation(this.getX(), 0);
        }
    }
}