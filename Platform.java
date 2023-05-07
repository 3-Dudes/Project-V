import greenfoot.*;
import java.util.*;
public class Platform extends Actor {
    private boolean shouldMove;
    private boolean shouldBounce;
    private boolean movingRight;
    private boolean movingLeft;
    private boolean movingUp;
    private List<Integer> sequence;
    private int sequenceIndex = 0;
    public Platform(boolean shouldMove, boolean shouldBounce, List<Integer> sequence) {
        this.shouldMove = shouldMove;
        this.shouldBounce = shouldBounce;
        GreenfootImage img = getImage();
        movingRight = true;
        movingLeft = false;
        movingUp = false;
        sequenceIndex = 0;
        this.sequence = sequence;
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
    }
    public Platform() {
        this(false, false, null);
    }
    public void act() {
        if(shouldMove) {
            bounce();
            changeDirection(50);
            if(movingRight) {
                setLocation(getX() + 5, getY());
            }  
            if(movingLeft && !movingRight) {
                setLocation(getX() - 5, getY());
            }
            if(!movingRight && !movingLeft) {
                if(movingUp) {
                    setLocation(getX(), getY() - 5);    
                }
                else {
                    setLocation(getX(), getY() + 5);
                }
            }
        }
    }
    private void bounce() {
        if(shouldBounce) {
            if(isAtEdge()) {
                sequenceIndex++;
            }
        }
    }
    private void changeDirection(int bound) {
        int startX = getX();
        int startY = getY();
        if(sequenceIndex >= sequence.size()) {
            sequenceIndex = 0;
        }
        switch(sequence.get(sequenceIndex)) {
            case 1:
                movingUp = true;
                movingLeft = false;
                movingRight = false;
                break;
            case 2:
                movingUp = false;
                movingLeft = false;
                movingRight = false;
                break;
            case 3:
                movingUp = false;
                movingLeft = true;
                movingRight = false;
                break;
            case 4:
                movingUp = false;
                movingLeft = false;
                movingRight = true;
                break;
        }
        if(!shouldBounce) {
            if(Math.abs(startX - getX()) == bound) {
                sequenceIndex++;
            }    
        }
    }
}