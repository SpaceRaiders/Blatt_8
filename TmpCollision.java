import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

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

    public Actor  getCollidingObject(Class objClass)
    {
        List<Actor> actors = getIntersectingObjects(objClass);

        for( Actor actor : actors )
        {
            TmpCollision tmp = (TmpCollision) actor ;
            if(tmp.isColliding(objClass)){ // hier muss noch allgemein hin
                return actor;
            }
        }
        return null;
    }

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

    /**
     * Testet auf neue Kollision( mit einer best. Klasse)
     * TODO: guter name 
     */
    public boolean neueKollsionmit(Class objClass)
    {
        List<Actor> objects = getIntersectingObjects(objClass);
        for(Actor object : objects )
        {
            for( Scrollable scrble : collObjcs)
            {
                if( object == (Actor) scrble){
                    collObjcs.add((Scrollable) object );
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * gibt einen 2 dimensionalen arraz mit den transparenten px zurueck ( true, wenn nicht transparent )
     */
    private boolean[][] getTransPx(GreenfootImage img)
    {
        boolean[][] imgTransp= new boolean[img.getWidth()][img.getHeight()];

        for(int i=0;i<img.getWidth();i++){
            for(int j=0; j < img.getHeight();j++){
                imgTransp[i][j]= img.getTransparency()==0 ? false : true; // false wenn transparent
            }
        }
        return imgTransp;
    }

    //hier der Code vom Anfang
    
    /*
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
     */
    /*
     * Testet auf Kollision mit einer best KLasse
     *
    public boolean isColliding(Class objClass)
    {
    return getOneIntersectingObject(objClass) != null ;
    }

    /**
     * Testet auf neue Kollision( mit einer best. Klasse)
     * TODO: guter name 
     *//*
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
    }*/
}
