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
            rocket.addItem(this);
            
            //setImage("void.png");
            //getWorld().removeObject((Scrollable)this);
        }
    }
}
