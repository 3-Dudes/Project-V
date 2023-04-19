import greenfoot.*;
public class Score extends Actor {
    private GreenfootImage score;
    private GreenfootImage cover;
    private int playerScore;
    private int cpuScore;
    public Score(int playerScore, int cpuScore) {
        score = new GreenfootImage(playerScore + " - " + cpuScore, 
            100, null, null);
        cover = new GreenfootImage(200, 75);
        cover.setColor(Color.WHITE);
        cover.fillRect(0, 0, cover.getWidth(), cover.getHeight());
        cover.drawImage(this.score, 23, -12);
        setScore(cover);
    }
    public void setScore(GreenfootImage cover) {
        this.cover = cover;
        this.setImage(cover);
    }
}