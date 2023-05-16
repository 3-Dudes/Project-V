import greenfoot.*;
public class GruHouse extends Stage {
    public GruHouse() {

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Balthazar balthazar = new Balthazar();
        addObject(balthazar,906,367);
    }
}
