import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

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
public class Scrollable extends TmpCollision//Actor
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
    
    // ---------------------- Collision ----------------------------------------------------------
    
    /**
     * Testet auf Kollision mit einer best KLasse
     */
    public boolean isColliding(Class objClass)
    {
        //return getOneIntersectingObject(objClass) != null ;

        //transparenz des einen bildes
        boolean[][] imgTransparency = getTransPx(getImage());

        List<Actor> actors = getIntersectingObjects(objClass);

        for( Actor object : actors){
            Scrollable tmp = (Scrollable) object;
            boolean[][] tmpTransparency = tmp.getTransPx(getImage());

            for(int i=0; i< imgTransparency.length ; i++){
                for( int j=0; j < imgTransparency[0].length; j++){
                    // umrechnung in int sp�ter?   --- getRealX() ?
                    double x1_welt = getRealX() + ( i -  getImage().getWidth()/2 ) * Math.cos(Math.toRadians(getRotation())) - (j-getImage().getHeight())*Math.sin(Math.toRadians(getRotation()));
                    double y1_welt = getRealY() + ( i -  getImage().getWidth()/2 ) * Math.sin(Math.toRadians(getRotation())) + (j-getImage().getHeight())*Math.cos(Math.toRadians(getRotation()));
                    
                    // umrechnung 2tes bils
                    double x2_px = tmp.getImage().getWidth()/2 + (x1_welt - tmp.getRealX())* Math.cos(Math.toRadians(tmp.getRotation())) + (y1_welt -tmp.getY())* Math.sin(Math.toRadians(tmp.getRotation()));
                    double y2_px = tmp.getImage().getHeight()/2 - (x1_welt - tmp.getRealX())* Math.sin(Math.toRadians(tmp.getRotation())) - (y1_welt -tmp.getY())* Math.cos(Math.toRadians(tmp.getRotation()));

                    if(0<=x2_px && 0<=y2_px && (int)x2_px < tmpTransparency.length && (int) y2_px < tmpTransparency[0].length ){
                        if( imgTransparency[i][j] &&  tmpTransparency[(int) x2_px][(int)y2_px]){
                            getImage().setColorAt(i, j,Color.RED);
                            System.out.println("Kollision bei "+ x1_welt+":"+y1_welt);
                        }
                    }

                }
            }
        }

        
        
        return false;
    }
    /**
     * Testet auf Kollision mit einer best KLasse
     */
    public boolean isColliding2(Class objClass)
    {
        //return getOneIntersectingObject(objClass) != null ;

        //transparenz des einen bildes
        boolean[][] imgTransparency = getTransPx(getImage());

        List<Actor> actors = getIntersectingObjects(objClass);

        for( Actor object : actors){
            TmpCollision tmp = (TmpCollision) object;
            boolean[][] tmpTransparency = tmp.getTransPx(getImage());

            for(int i=0; i< imgTransparency.length ; i++){
                for( int j=0; j < imgTransparency[0].length; j++){
                    // umrechnung in int sp�ter?   --- getRealX() ?
                    double x1_welt = getX() + ( i -  getImage().getWidth()/2 ) * Math.cos(Math.toRadians(getRotation())) - (j-getImage().getHeight())*Math.sin(Math.toRadians(getRotation()));
                    double y1_welt = getY() + ( i -  getImage().getWidth()/2 ) * Math.sin(Math.toRadians(getRotation())) - (j-getImage().getHeight())*Math.cos(Math.toRadians(getRotation()));

                    //getImage().setColorAt(i, j,Color.RED);
                    // umrechnung 2tes bils
                    double x2_px = tmp.getImage().getWidth()/2 + (x1_welt - tmp.getX())* Math.cos(Math.toRadians(tmp.getRotation())) + (y1_welt -tmp.getY())* Math.sin(Math.toRadians(tmp.getRotation()));
                    double y2_px = tmp.getImage().getHeight()/2 - (x1_welt - tmp.getX())* Math.sin(Math.toRadians(tmp.getRotation())) + (y1_welt -tmp.getY())* Math.cos(Math.toRadians(tmp.getRotation()));

                    if(0<=x2_px && 0<=y2_px && (int)x2_px < tmpTransparency.length && (int) y2_px < tmpTransparency[0].length ){
                        if( imgTransparency[i][j] &&  tmpTransparency[(int) x2_px][(int)y2_px]){
                            getImage().setColorAt(i, j,Color.RED);
                            
                        }
                    }

                }
            }
        }

        
        
        return false;
    }
    public boolean isColliding3(Class objClass)
    {
        //transparenz des einen bildes
        boolean[][] imgTransparency = getTransPx(getImage());

        List<Actor> actors = getIntersectingObjects(objClass);
        
        //hier für alle Actoren pruefen
        for(Actor object : actors)
        {
            //hier gäbe es errors wenn objClass keine unterklasse von SCrollable oder SCrollable ist
            Scrollable tmp = (Scrollable) object;
            
            boolean[][] tmpTransparency = tmp.getTransPx(tmp.getImage());
            System.out.println("---------------------\n"+tmp.getImage().getWidth()+":"+tmp.getImage().getHeight());
            
            //hier geht man jeden Pixel des Bildes durch
            for(int i=0; i< imgTransparency.length ; i++){
                for( int j=0; j < imgTransparency[0].length; j++){
                    //Berechnung von x Welt und Y Welt
                    //double x1_welt = getRealX() + (i- getImage().getWidth()/2)*Math.cos(Math.toRadians(getRotation())) - (j - getImage().getHeight()/2)*Math.sin(Math.toRadians(getRotation()));
                    //double y1_welt = getRealY() + (i- getImage().getWidth()/2)*Math.sin(Math.toRadians(getRotation())) + (j - getImage().getHeight()/2)*Math.cos(Math.toRadians(getRotation()));
                    double x1_welt = getX() + (i- getImage().getWidth()/2)*Math.cos(Math.toRadians(getRotation())) - (j - getImage().getHeight()/2)*Math.sin(Math.toRadians(getRotation()));
                    double y1_welt = getY() + (i- getImage().getWidth()/2)*Math.sin(Math.toRadians(getRotation())) + (j - getImage().getHeight()/2)*Math.cos(Math.toRadians(getRotation()));
                    
                    //Berechnung in (theoretischen) Koordinaten des zweiten Bildes
                    //double x2_px= tmp.getImage().getWidth()/2  + (x1_welt - tmp.getRealX())*Math.cos(Math.toRadians(tmp.getRotation()))+(y1_welt - tmp.getRealX())*Math.sin(Math.toRadians(tmp.getRotation()));
                    //double y2_px= tmp.getImage().getHeight()/2 - (x1_welt - tmp.getRealX())*Math.sin(Math.toRadians(tmp.getRotation()))+(y1_welt - tmp.getRealX())*Math.cos(Math.toRadians(tmp.getRotation()));
                    double x2_px= tmp.getImage().getWidth()/2  + (x1_welt - tmp.getX())*Math.cos(Math.toRadians(tmp.getRotation()))+(y1_welt - tmp.getRealX())*Math.sin(Math.toRadians(tmp.getRotation()));
                    double y2_px= tmp.getImage().getHeight()/2 - (x1_welt - tmp.getX())*Math.sin(Math.toRadians(tmp.getRotation()))+(y1_welt - tmp.getRealX())*Math.cos(Math.toRadians(tmp.getRotation()));
                    
                    System.out.println(x2_px+":"+y2_px);
                    
                    //sind dei Koordinaten überhaupt im 2ten bild?
                    if(0<= x2_px && 0<=y2_px && x2_px<tmpTransparency.length && y2_px<tmpTransparency[0].length)
                    {
                        // sind beide sichtbar?
                        if(imgTransparency[i][j] && tmpTransparency[(int)x2_px][(int)y2_px])
                        {
                            getImage().setColorAt(i, j,Color.RED);
                        }
                        
                    }
                    
                }
                
            }
        }
        return false;
    }
    
    public void transparencytest()
    {
        GreenfootImage img = getImage();
        boolean[][] transparency = getTransPx(img);
        for(int i=0; i< transparency.length; i++){
            for( int j=0; j<transparency[0].length;j++){
                if(transparency[i][j]){
                    getImage().setColorAt(i, j,Color.BLUE);
                }
            }
        }
        
    }
    
    
    /**
     * gibt einen 2 dimensionalen arraz mit den koordinaten der transparenten px zurueck ( true, wenn nicht transparent )
     */
    public boolean[][] getTransPx(GreenfootImage img)
    {
        boolean[][] imgTransp= new boolean[img.getWidth()][img.getHeight()];

        for(int i=0;i<img.getWidth();i++){
            for(int j=0; j < img.getHeight();j++){
                imgTransp[i][j]=  img.getColorAt(i,j).getAlpha()!=0; // false wenn transparent
            }
        }
        return imgTransp;
    }
    
}
