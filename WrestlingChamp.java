public class WrestlingChamp extends Ability 
{
    // instance variables - replace the example below with your own
    private boolean movingRight;
    public WrestlingChamp(boolean movingRight)
    {
        super(1000, 20);
        this.movingRight = movingRight;
    }

    @Override
    public void act() {
        super.act();
        if(movingRight) {
         this.setRotation(90);
           this.setLocation(this.getX() + 10, this.getY());
        }
        else {
            this.setRotation(270);
            this.setLocation(this.getX() - 10, this.getY());    
        }
    }
}
