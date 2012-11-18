import greenfoot.*;

/**
 * Klasse Shield : Dieses Item erlaubt, eine Rackette durch ein schwarze loch zu gehen.
 * 
 * @author Vitalij Kochno - Yorick Netzer - Christophe Stilmant
 * @version 11-11-2012
 */
public class Shield extends Item
{
    /**
     * firstCollision : Diese Variable ist nötig, um die Kollisionsüberwachung zwichen eine Rackette
     * und das Shild zu stoppen; so wird die Funktion checkCollision(nur aufgerugen, wenn das Shild
     * noch sichtbar ist).
     * 
     * false : Das Shild wurde von keine Rackette gefressen.
     * true : Das Shild wurde schon in Kontakt mit eine Rackette
     */
    private boolean firstCollision = false;

    /**
     * Diese Methode wird immer angerufen, wenn die Taste 'Act' oder 'Run' gedrückt ist.
     * Hier wird auf Mausklicks reagiert und eine Object der Bulet Klasse der Welt hinzugefügt.
     */
    public void act() 
    {
        if(!firstCollision)
        {
            checkCollision();
        }
    }
    
    /**
     * Diese Methode überprüft, ob das Shield-Objekt eine Kollision mit eine Rakete-Objekt hat.
     */
    private void checkCollision()
    {
        if(getOneIntersectingObject(Rocket.class) != null)
        {
            Rocket rocket = (Rocket) getOneIntersectingObject(Rocket.class);
            // Das Item Shiel wird in der Inventar der Rackette hinzugefügt.
            rocket.addItem(this);
            /* Diese Funktion wird jetzt nich mehr aufgerunfen, solang
            firstCollision das Wert "true" hat. */
            firstCollision = true;
        }
    }
    
    /**
     * Diese Funktion Fragt, ob man in der Act() Funktion wieder die
     * Kollisionen mit der Rackette checken muss.
     */
    public void setCheckCollision(boolean check)
    {
        firstCollision = check;
    }
}
