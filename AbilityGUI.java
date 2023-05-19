import greenfoot.*;
public class AbilityGUI extends Actor {
    public AbilityGUI(ImageActor c, ImageActor q, ImageActor e, 
        ImageActor x, Ability b, Ability v) {
        
    }
    public void act()
    {
        
    }
    private void addAbilityToGUI(Ability ab, int x, int y) {
        if(ab != null && ab.isReady()) {
            getWorld().addObject(new ImageActor(ab), x, y);
        }
    }
}
