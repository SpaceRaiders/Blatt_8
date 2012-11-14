import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Andromeda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Andromeda extends ScrollableWorld
{

    /**
     * Constructor for objects of class Andromeda.
     * 
     */
    public Andromeda(int lvl)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,1200,800,lvl); 
        initRocket(new Rocket(),400,300);
         
        prepare();
    }
    public Andromeda(Pose pose)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1,2400,1600,0); 
        initRocket(new Rocket(),pose.getX(),pose.getY());
         
        prepare();
    }
    public void prepare()
    {
         initObj(new Rocket(),400,300);
         initObj(new Asteroid(),300,600);
    }
}
