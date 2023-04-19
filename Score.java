import greenfoot.*;
public class Score extends Actor {
    private GreenfootImage score;
    private int playerScore;
    private int cpuScore;
    public Score(int playerScore, int cpuScore) {
        score = new GreenfootImage(playerScore + " - " + cpuScore, 
            100, null, null);
        setScore(score);
    }
    public void setScore(GreenfootImage score) {
        this.score = score;
        this.setImage(this.score);
    }
}