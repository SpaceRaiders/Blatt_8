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
    private final int MAX_LVL=2;
    private Class next=null;
    
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addLvl();
        next=worlds.get(0).getClass();
    }
    public MainMenu(int lvl)
    {
        super(600, 400, 1); 
        addLvl();
        if(lvl<MAX_LVL)
        {
            this.lvl=lvl+1;
        }
        else
        {
            this.lvl=0;
        }
        next=worlds.get(lvl).getClass();
    }
    public MainMenu(Class cls, Pose pose)
    {
        super(600, 400, 1); 
        addLvl(pose);
        //System.out.println(cls);
        next=cls;
    }
    private void addLvl(Pose pose)
    {
        
        worlds.add(new Space(pose));
        worlds.add(new Andromeda(pose));
    }
    
    private void addLvl()
    {
        
        worlds.add(new Space());
        worlds.add(new Andromeda());
    }
    
    public void act()
    {
        
        Greenfoot.setWorld(get(next));
        /*
        if(Greenfoot.isKeyDown("n"))
        {
            
            //Greenfoot.setWorld(worlds.get(lvl));
            Greenfoot.setWorld(get(Andromeda.class));
        }
        
        if(Greenfoot.isKeyDown("h"))
        {
            
            //Greenfoot.setWorld(worlds.get(lvl));
            Greenfoot.setWorld(get(Space.class));
        }
         if(Greenfoot.isKeyDown("g"))
        {
            
            //Greenfoot.setWorld(worlds.get(lvl));
            Greenfoot.setWorld(get(Andromeda.class));
        }*/
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
