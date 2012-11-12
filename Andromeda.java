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
        initObj(new Rocket(),400,300);
    }
}
