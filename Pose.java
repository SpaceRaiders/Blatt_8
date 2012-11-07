import greenfoot.*;
/**
 * Für Aufgabe 2
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pose  
{
    private int x,y,rot;
    private Actor actor;

    /**
     * Constructor for objects of class Pose
     */
    public Pose(Actor actor)
    {
        this.actor=actor;
        x=actor.getX();
        y=actor.getY();
        rot=actor.getRotation();
        
    }

    public void update(Actor actor)
    {
        
    }
    
    public void resetActor()
    {
        actor.setLocation(x,y);
        actor.setRotation(rot);
    }
}
