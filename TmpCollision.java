import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Extra Klasse fuer uebersichtlichkeit, solln spaeter nicht in der abdgabe vorkommen
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TmpCollision extends Actor
{
    private ArrayList<Scrollable> collObjcs = new ArrayList<Scrollable>();
    
    /**
     * @return Collidierendes Object bzw null 
     */
    public Actor  getCollidingObject(Class ObjClass)
    {
       Actor actor = getOneIntersectingObject(ObjClass);
        
       if(actor != null)
       {
           return actor;
        }
        else{
            return null;
        }
    }
    
    /**
     * Testet auf Kollision mit einer best KLasse
     */
    public boolean isColliding(Class objClass)
    {
        return getOneIntersectingObject(objClass) != null ;
    }
    
    /**
     * Testet auf neue Kollision( mit einer best. Klasse)
     * TODO: guter name 
     */
    public boolean neueKollsionmit(Class objClass)
    {
        List<Actor> objects = getIntersectingObjects(objClass);
        for(Actor object : objects )
        {
            boolean newObj= false;
            for( Scrollable scrble : collObjcs)
            {
                if( object == (Actor) scrble){
                    newObj = true;
                }
                
            }
            if( newObj )
            {
                collObjcs.add((Scrollable) object );
                return true;
            }
        }
        return false;
    }
}
