import greenfoot.*;
/**
 * Für Aufgabe 2
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pose  
{
    private int x,y,shift_x,shift_y,rot;
    private Scrollable scrble;

    /**
     * Constructor for objects of class Pose
     */
    public Pose(Scrollable scrble)
    {
        this.scrble=scrble;
        
    }

    public void update()
    {
        x=scrble.getRealX();
        y=scrble.getRealY();
        shift_x=scrble.getScrWorld().getShiftX();
        shift_y=scrble.getScrWorld().getShiftY();
        rot=scrble.getRotation();
    }
    
    public void resetActor()
    {
        scrble.setLocation(x+shift_x,y+shift_y);
        scrble.getScrWorld().setShift(shift_x,shift_y);
        
        scrble.setRotation(rot);
    }
}
