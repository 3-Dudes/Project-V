import greenfoot.*;
public class GruHouse extends Stage {
    public GruHouse() {
        prepare();
    }    
    
    private void prepare() {
        //Vector vector = new Vector();
        //addObject(vector, 1051, 280);

        //PiranhaGun piranhaGun = new PiranhaGun();
        //addObject(piranhaGun, 975, 280);
        ElMacho elMacho = new ElMacho();
        addObject(elMacho, 178, 550);

        Vector vector = new Vector();
        addObject(vector,1048,552);

        vector.setLocation(1061,568);
        vector.setLocation(690,549);
        TortillaChip tortillachip = new TortillaChip();
        addObject(tortillachip,76,126);
        tortillachip.setLocation(44,658);
        tortillachip.setLocation(421,627);
        removeObject(tortillachip);
        Laser laser = new Laser();
        addObject(laser,570,331);
        removeObject(laser);
        elMacho.setLocation(162,505);
        elMacho.setLocation(138,517);
        elMacho.setLocation(138,517);
        removeObject(elMacho);
        removeObject(vector);
        ElMacho elmacho2 = new ElMacho();
        addObject(elmacho2,605,522);
        elmacho2.setLocation(396,529);
        Vector vector2 = new Vector();
        addObject(vector2,853,541);
        vector2.setLocation(806,526);
        removeObject(vector2);
        BubbleGum bubbleGum = new BubbleGum();
        addObject(bubbleGum,252,525);
    }
}
