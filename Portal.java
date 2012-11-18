import greenfoot.*;

/**
 * Klasse Portal : Dieses Item erlaubt, eine Rackette die Welt zu wechseln.
 * 
 * @author Vitalij Kochno - Yorick Netzer - Christophe Stilmant
 * @version 16-11-2012
 */
public class Portal extends Scrollable
{
    /**
     * Dieser Attribut speichert die Welt, wo das Portal führt.
     */
    private Class nextLvl = Andromeda.class;
    
    /**
     * 
     */
    public Portal()
    {
        
    }
    
    /**
     * 
     */
    public Portal(Class next)
    {
        nextLvl = next;
    }
    
    /**
     * Diese Methode wird immer angerufen, wenn die Taste 'Act' oder 'Run' gedrückt ist.
     * Hier wird auf Mausklicks reagiert und eine Object der Bulet Klasse der Welt hinzugefügt.
     */
    public void act() 
    {
        Rocket rocket = (Rocket)getOneIntersectingObject(Rocket.class);
        if(rocket!=null )
        {
            System.out.println(rocket.getPose());
            Greenfoot.setWorld(new MainMenu(nextLvl,rocket.getPose()));
        }
    }    
}
