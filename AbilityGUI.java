import greenfoot.*;
public class AbilityGUI extends Actor {
    public AbilityGUI(Ability c, Ability q, Ability e, 
        Ability x, Ability b, Ability v) {
        addAbilityToGUI(c, 200, 100);
        addAbilityToGUI(q, 300, 100);
        addAbilityToGUI(e, 400, 100);
        addAbilityToGUI(x, 500, 100);
        addAbilityToGUI(b, 600, 100);
        addAbilityToGUI(v, 700, 100);
    }
    private void addAbilityToGUI(Ability ab, int x, int y) {
        if(ab != null && ab.isReady()) {
            getWorld().addObject(new ImageActor(ab), x, y);
        }
    }
}