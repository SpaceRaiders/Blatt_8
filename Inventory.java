import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList ;

/**
 * Write a description of class Inventory here.
 * 
 * @author Vitalij Kochno - Yorick Netzer - Christophe Stilmant
 * @version 09-11-2012
 */
public class Inventory extends Actor
{

    private ArrayList<Scrollable> items = new ArrayList<Scrollable>();
    
    /**
     * Definiert, wo das Item auf das Bild sich befinden soll.
     */
    private int posItem_y = 55;
    
    /**
     * Definiert, wieviel Item das Inventar enthälten darf.
     */
    static private int ITEM_MAX = 6;
      
    /**
     * 
     */
    public void storeActor(Actor actor)
    {
        
    }
    
    /**
     * Speichert ein Item in das Inventar, wenn es nicht voll ist.
     */
    public void storeItem(Item item)
    {
        System.out.println("how many items in Inventory? : " + items.size());
        if (items.size() < ITEM_MAX)
        {
            storeScrble(item);
        }
    }
    
    /**
     * Speicehrt ein Scrollable-Object im inventar. Wenn schon ein Object im 
     * inventar ist, wird dieses an der Stelle abegeworfen.
     */
    public void storeScrble(Scrollable scrble)
    {
        //if(!isEmpty())
        //{
            //removeScrble(scrble.getX(),scrble.getY());
        //}
        //else
        //{
            System.out.println("add new Item : " + scrble);
            items.add(scrble);
            World world = scrble.getWorld();
            scrble.getScrWorld().removeObject(scrble);
            world.addObject(scrble,955, posItem_y);
            
            // Das nächste Item wird weiter nach unten gezeigt.
            posItem_y += 100;
        //}
        
    }
    
    public void removeScrble(int x,int y)
    {
        get().getWorld().removeObject(get());
        get().getScrWorld().initObj(get(), x, y);
    }
    
    public Scrollable get()
    {
        return get(0);
    }
    
    public Scrollable get(int i)
    {
        if (i < 0 || i >= items.size())
        //if (items.size()<=0)
        {
            return null;
        }
        else
        {
            return items.get(i);
        }
    }
    
    /**
     * 
     */
    public void clean()
    {
        
    }
    
    /**
     * 
     */
    public boolean isEmpty()
    {
        if(items.size()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
