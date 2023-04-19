import greenfoot.*;
public class Score extends Actor {
    private GreenfootImage score;
    private int playerScore;
    private int cpuScore;
    public Score(int playerScore, int cpuScore) {
        score = new GreenfootImage("Score " + playerScore + " - " + cpuScore, 
            100, null, null);
    }
    public void setScore(GreenfootImage score) {
        this.score = score;
        this.setImage(this.score);
    }
}