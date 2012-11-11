import greenfoot.*;
/**
 * Für Aufgabe 2
 * 
 * @author Vitalij Kochno - Yorick Netzer - Christophe Stilmant
 * @version 08-11-2012
 */
public class Pose  
{
    private int x,y,rot;
    private int shift_x,shift_y;
    private Scrollable scrble;

    /**
     * Kostruktor. Hier wird der Klasse Pose eine ?Referenz? auf ein Scrollable Object gegeben.
     * ( Scrollable ist eine Unterklasse von Actor).
     */
    public Pose(Scrollable scrble)
    {
        this.scrble=scrble;
        
    }
    /**
     * Aktualisiert die Werte von Pose d.h. die x und y Koordinate und die Drehung.
     * Wird zu Beginn der act() Methode aufgerufen.
     */
    public void update()
    {
        x=scrble.getX();
        y=scrble.getY();
        rot=scrble.getRotation();
    }
    /**
     * Verschiebt das Scrollable-Object (die Rakete) so, dass der vorherige Zug rückgängig gemacht wird.
     */
    public void resetActor()
    {
        
        
        int dx,dy;
        dx=scrble.getX()-x;
        dy=scrble.getY()-y;
        scrble.setRealX(scrble.getRealX()-dx);
        scrble.setRealY(scrble.getRealY()-dy);
        scrble.setLocation(x,y);
        //System.out.println("Scroll: "+dx+":dx    "+dy+":dy");
        
        scrble.setRotation(rot);
    }
}
