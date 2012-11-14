import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Scrollable
{
    private Class nextLvl=Space.class;
    public Portal()
    {
        
    }
    public Portal(Class next)
    {
        nextLvl=next;
    }
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Rocket rocket=(Rocket)getOneIntersectingObject(Rocket.class);
        if(rocket!=null )
        {
            System.out.println(rocket.getPose());
            Greenfoot.setWorld(new MainMenu(nextLvl,rocket.getPose()));
        }
    }    
}
