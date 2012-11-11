import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList ;
import java.awt.Point ;
/**
 * Das WEltall. Jetzt mit SCrollen . TODO muss auf kollisionen prüfen und dann dodamge o.Ä.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends ScrollableWorld
{
    //private ArrayList<greenfoot.Actor> objects = new ArrayList<greenfoot.Actor>();
    private ArrayList<Scrollable> objects = new ArrayList<Scrollable>();
    //private ArrayList<Point> realPos = new ArrayList<Point>();
    private int grenze = 100,width=2400,height=1600,shiftX=0,shiftY=0;
    
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1,2400,1600); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Rocket rocket = new Rocket();
        initObj(rocket, getWidth()/2, getHeight()/2);
        /*
        Asteroid asteroid = new Asteroid();
        initObj(asteroid, 666, 416);
        Asteroid asteroid2 = new Asteroid();
        initObj(asteroid2, 708, 640);
        Asteroid asteroid3 = new Asteroid();
        initObj(asteroid3, 1055, 636);
        Asteroid asteroid4 = new Asteroid();
        initObj(asteroid4, 904, 493);
        Asteroid asteroid5 = new Asteroid();
        initObj(asteroid5, 1019, 423);*/
        initObj(new Asteroid(),1600, 900);
        SpaceLemon spacelemon = new SpaceLemon();
        initObj(spacelemon, 738, 147);
        SpaceLemon spacelemon2 = new SpaceLemon();
        initObj(spacelemon2, 410, 118);
        Blackhole blackhole = new Blackhole();
        initObj(blackhole, 761, 423);
        Blackhole blackhole2 = new Blackhole();
        initObj(blackhole2, 1285, 255);
        Shield shield = new Shield();
        initObj(shield, 331, 357);
        Shield shield2 = new Shield();
        initObj(shield2, 454, 1000);
        Shield shield3 = new Shield();
        initObj(shield3, 300, 536);
        Shield shield4 = new Shield();
        initObj(shield4, 2000, 91);
        shield3.setLocation(92, 542);
        shield2.setLocation(989, 595);
    }
}
