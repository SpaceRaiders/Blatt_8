import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Act - 
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
            /* Falls das Shiel in Kollision mit der Rackette kommt, wird
            es nicht gelöcht, sonder nur unsichtbar gemacht. */
            //setImage("void.png");
            // Das Item Shiel wird in der Inventar der Rackette hinzugefügt.
            rocket.addItem(this);
            /* Diese Funktion wird jetzt nich mehr aufgerunfen, solang
            firstCollision das Wert "true" hat. */
            firstCollision = true;
        }
    }
}
