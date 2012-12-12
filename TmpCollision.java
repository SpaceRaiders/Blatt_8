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
