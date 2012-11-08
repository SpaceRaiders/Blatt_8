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
        x=scrble.getX();
        y=scrble.getY();
        shift_x=scrble.getScrWorld().getShiftX();
        shift_y=scrble.getScrWorld().getShiftY();
        rot=scrble.getRotation();
    }
    
    public void resetActor()
    {
        
        //scrble.getScrWorld().srcoll(x-scrble.getX(),y-scrble.getY());
        //scrble.getScrWorld().setShift(shift_x,shift_y);
        int dx,dy;
        dx=scrble.getX()-x;
        dy=scrble.getY()-y;
        scrble.setRealX(scrble.getRealX()-dx);
        scrble.setRealY(scrble.getRealY()-dy);
        scrble.setLocation(x,y);
        System.out.println("Scroll: "+dx+":dx    "+dy+":dy");
        //scrble.getScrWorld().scroll(x-scrble.getX(), y-scrble.getY());
        //System.out.println(x-scrble.getX()+" dx    "+(y-scrble.getY())+" dy");
        
        //scrble.getScrWorld().scroll(10,10);
        //scrble.setRotation(rot);
    }
}
