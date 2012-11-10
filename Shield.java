import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Scrollable
{
    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkCollision();
    }
    
    /**
     * Diese Methode überprüft, ob das Shield-Objekt eine Kollision mit eine Rakete-Objekt hat.
     */
    private void checkCollision()
    {
        if( getOneIntersectingObject(Rocket.class) != null)
        {
            Rocket rocket = (Rocket) getOneIntersectingObject(Rocket.class);
            // die Nummer des gerettetes Astronautes wird mit 1 addiert.
            //rocket.addItem(this);
            
            /* der Astronaut ist gerettet : Er befindet sich jetzt in die Rackette; deshalb muss
             * man den löschen um den unsichtbar zu machen. */
            //getWorld().removeObject((Scrollable)this);
        }
    }
}
