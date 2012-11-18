import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Oberklasse aller SCrollbaren Objecte.
 * Wird zum einem zur identifizierung, ob ein Object Scrollbar ist genutzt. Dann gibt es noch ein paar andere Methoden,
 * z.B. setVisible inzwischen im Prinzip überholt, diese MEthode erstzt das Bild durch eine 1px großen transparentes Bild.
 * Ich bin mir momentan nicht sicher ob real_x überhaupt genutzt wird. 
 * Die move ist für die Raktete wichtig, amsonsten kann die Raktete die Welt velassen ( einfach im Konstuktor der Rakete super(true) anstatt super(false) um ausprobieren. 
 * 
 * @author Vitalij Kochno - Yorick Netzer - Christophe Stilmant
 * @version 18-11-2012
 */
public class Scrollable extends Actor
{
    /**
     * 
     */
    GreenfootImage img = null;
    
    /**
     * 
     */
    GreenfootImage img_trans=null;
    
    /**
     * 
     */
    private int atWorldEdge_grenze = 20;
    
    /**
     * 
     */
    private int real_x, real_y;
    
    /**
     * 
     */
    protected ScrollableWorld space = null;
    
    
    /**
     * 
     */
    private boolean canleave = true;
    
    /**
     * Konstruktor
     */
    public Scrollable()
    {
        
    }
    
    /**
     * Konstruktor
     */
    public Scrollable(boolean canleaveWorld)
    {
        canleave = canleaveWorld;
    }
    
    /**
     * Diese Methode wird immer angerufen, wenn die Taste 'Act' oder 'Run' gedrückt ist.
     * Hier wird auf Mausklicks reagiert und eine Object der Bulet Klasse der Welt hinzugefügt.
     */
    public void act() 
    {
        setLocation(real_x+space.getShiftX(),real_y+space.getShiftY());
        checkvsbl();
    }
    
    /**
     * Bild übergeben, dass genutzt wird, wenn Objekt auf Bildschirm sichtbar.
     */
    public void setvisibleImg(GreenfootImage img_tmp)
    {
        img=img_tmp;
        img_trans=new GreenfootImage("void.png");
    }
    
    /**
     * Sichtbarkeit auf Bildschirm einstellen
     */
    public void setVisible(boolean vsbl)
    {
        if(vsbl)
        {
            setImage(img);
        }
        else
        {
            setImage(img_trans);
        }
    }
    
    /**
     * wenn Objekt am Rand des Feldes, wird es unsichtbar, siehe setVisible()
     */
    public void checkvsbl()
    {
        setVisible(!atWorldEdge());
    }
    
    /**
     * @return true, wenn weniger als atWorldEdge_grenze von Spielfeldrand entfernt
     */
    public boolean atWorldEdge()
    {
        if(getX() < atWorldEdge_grenze || getX() > getWorld().getWidth() - atWorldEdge_grenze 
        || getY() < atWorldEdge_grenze || getY() > getWorld().getHeight() - atWorldEdge_grenze)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
    /**
     * einmal kurz Startwerte für real_x und real_y übergeben , da sie nicht von Beginn an auf z.B. getX() zugreifen können
     */
    public void init(int x_start, int y_start, ScrollableWorld space_tmp)
    {
        real_x = x_start;
        real_y = y_start;
        space = space_tmp;
    }
    
    /**
     * @return Die Welt, wo das Objekt sich befindet.
     */
    public ScrollableWorld getScrWorld()
    {
        return space;
    }
    
    /**
     * Diese Funktion definiert, wo ein das Objekt sich in X befinden muss.
     * 
     * @param die Ware Y Position
     */
    public void setRealX(int realX)
    {
        real_x=realX;
    }
    
    /**
     * Diese Funktion definiert, wo ein das Objekt sich in Y befinden muss.
     * 
     * @param die Ware Y Position
     */
    public void setRealY(int realY)
    {
        real_y=realY;
    }
    
    /**
     * @return die Ware X Position
     */
    public int getRealX()
    {
        return real_x;
    }
    
    /**
     * @return die Ware Y Position
     */
    public int getRealY()
    {
        return real_y;
    }
    
    /**
     * Move von Actor überschrieben bzw erweitert, damit man die echte position ( nicht nur 
     * die auf dem Bildschirm) bekommt
     */
    public void move(int distance)
    {
        int movex=0, movey=0,dx, dy;
        dx= getX();
        dy= getY();
        super.move(distance);
        dx= getX()-dx;
        dy= getY()-dy;
        real_x+=dx;
        real_y+=dy;
            
        if(canleave)
        {
            //real_x+=dx;
            //real_y+=dy;
            //System.out.println("canleave");
        }
        else
        {
            
            while(real_x+space.getShiftX()+movex<0)
            {
                movex++;
                //System.out.println("movex vergröernt");
            }
            while(real_x+space.getShiftX()+movex>getWorld().getWidth())
            {
                movex--;
                //System.out.println("movex verkleinert");
            }
            while(real_y+space.getShiftY()+movey<0)
            {
                movey++;
                //System.out.println("movey vergröernt");
            }
            while(real_y+space.getShiftY()+movey>getWorld().getHeight())
            {
                movey--;
                //System.out.println("movey verkleinert");
            }
            real_x=real_x+movex;
            real_y=real_y+movey;
            
            
        }
        setLocation(real_x+space.getShiftX()+movex,real_y+space.getShiftY()+movey);
        
        //System.out.println(toString()+"   x:" +getX()+":"+(real_x+space.getShiftX())+":"+real_x+"   y:"+getY()+":"+real_y);
    }
}
