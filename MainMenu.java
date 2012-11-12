import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList ;
/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    private ArrayList<World> worlds = new ArrayList<World>();
    private int lvl=0;
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        worlds.add(new Space(0));
        worlds.add(new Andromeda(1));
    }
    public MainMenu(int lvl)
    {
        super(600, 400, 1); 
        worlds.add(new Space(0));
        worlds.add(new Andromeda(1));
        this.lvl=lvl+1;
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("h"))
        {
            
            //Greenfoot.setWorld(worlds.get(lvl));
            Greenfoot.setWorld(get(Space.class));
        }
         if(Greenfoot.isKeyDown("g"))
        {
            
            //Greenfoot.setWorld(worlds.get(lvl));
            Greenfoot.setWorld(get(Andromeda.class));
        }
    }
    public World get(Class cls)
    {
        for(int i=0; i < worlds.size();i++)
        {
            if(isOfClass(worlds.get(i),cls))
            {
                return worlds.get(i);
            }
        }
        return null;
        
        
        
    }
    private   boolean isOfClass(World w, Class c)
    {
        return w.getClass() == c;
    }

}
