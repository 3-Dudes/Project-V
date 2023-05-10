import greenfoot.*;
public class Zone extends Actor {
    private GreenfootImage captureBar;
    private GreenfootImage marker;
    private Color captureColor;
    public Zone(Color captureColor) {
        captureBar = new GreenfootImage(50, 200);
        marker = new GreenfootImage(50, 50);
        marker.setColor(Color.WHITE);
        marker.fill();
        captureBar.setColor(Color.WHITE);
        captureBar.fill();
        this.captureColor = captureColor;
    }
    public void act() {
        if(isCaptured()) {
            
        }
    }
    public boolean isCaptured() {
        /* GreenfootImage tempRect = new GreenfootImage(30, 30);
        tempRect.setColor(captureColor);
        tempRect.fillRect(tempRect.getWidth()
        captureBar.drawImage(tempRect, 
            captureBar.getWidth(), captureBar.getHeight()); */
        return false;
    }
    public void capture() {
        captureBar.setColor(captureColor);
        if(!isCaptured()) {
            
        }
    }
    public GreenfootImage getCaptureBar() {
        return captureBar;
    }
    public GreenfootImage getMarker() {
        return marker;
    }
}
