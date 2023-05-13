import greenfoot.*;
public class BombPool extends Actor {
    private static final int poolSize = 10;
    private Bomb[] bombs;
    private int nextIndex;
    public BombPool() {
        bombs = new Bomb[poolSize];
        for(int i = 0; i < bombs.length; i++) {
            bombs[i] = new Bomb();
        }
        nextIndex = 0;
    }
    public Bomb getBomb() {
        if(nextIndex < poolSize) {
            Bomb bomb = bombs[nextIndex];
            nextIndex++;
            return bomb;
        }
        return null;
    }    
    public void returnAllBombs() {
        nextIndex = 0;
        for(int i = 0; i < poolSize; i++) {
            bombs[i].reset(0, 0);
        }
    }
}