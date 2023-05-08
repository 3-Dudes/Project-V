import greenfoot.*;
public class ElMachoAnimated extends Actor {
    private GreenfootImage[] rightMachoFrames;
    private GreenfootImage[] leftMachoFrames;
    private int currentFrame;
    private boolean facingRight;
    private int frameDelay;
    private boolean isMoving;
    public ElMachoAnimated() {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        rightMachoFrames = new GreenfootImage[21];
        for(int i = 0; i < rightMachoFrames.length; i++) {
            rightMachoFrames[i] = new GreenfootImage("macho" + (i + 1) + ".png");
            rightMachoFrames[i].scale(rightMachoFrames[i].getWidth() / 2, 
                rightMachoFrames[i].getHeight() / 2);
        }
        leftMachoFrames = new GreenfootImage[21];
        for(int i = 0; i < leftMachoFrames.length; i++) {
            leftMachoFrames[i] = new GreenfootImage(rightMachoFrames[i]);
            leftMachoFrames[i].mirrorHorizontally();
        }
        currentFrame = 0;
        frameDelay = 0;
        facingRight = true;
        isMoving = false;
    }
    public void act() {
        if(Greenfoot.isKeyDown("D")) {
            setLocation(getX() + 5, getY());
            animate();
            isMoving = true;
            facingRight = true;
        }
        else if(Greenfoot.isKeyDown("A")) {
            setLocation(getX() - 5, getY());
            animate();
            isMoving = true;
            facingRight = false;
        }
        else {
            isMoving = false;
        }
        if(!isMoving) {
            if(facingRight) {
                setImage(rightMachoFrames[0]);
            }
            else {
                setImage(leftMachoFrames[0]);
            }
        }
    }
    private void animate() {
        if(facingRight) {
            setImage(rightMachoFrames[currentFrame]);   
        }
        else {
            setImage(leftMachoFrames[currentFrame]);
        }
        if(frameDelay == 5) {
            currentFrame++;    
            frameDelay = 0;
        }
        frameDelay++;
        if(currentFrame == 21) {
            currentFrame = 0;
        }
    }
}