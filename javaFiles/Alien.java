/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * File Name: Alien class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The Alien class extends the Invader class
 * The Alien class has a no argument constructor and another
 * constructor that passes in a color variable
 * The main purpose of the Alien class is to draw the Aliens 
 * that will  be used has enemies in the game
 */
public class Alien extends Invader 
{
    private int alienType;
    private Rectangle rect;
    private Color c = Color.white;
    
    public Alien()
    {
        super();

        alienType = 0;
        rect = new Rectangle();
        
    }
    
    public Alien(Color c)
    {
        this.c = c;
    }

    /**
     * @return the alienType
     */
    public int getAlienType() {
        return alienType;
    }

    /**
     * @param alienType the alienType to set
     */
    public void setAlienType(int alienType) {
        this.alienType = alienType;
    }
    
    public void setAlien(Alien a) {
        this.alienType = alienType;
    }
    
    @Override
    public void draw(Graphics g)
    {
        if(this.isVisible())
        {    
            
       
         setRect(new Rectangle(getX(), getY(), 30, 30));
         if(alienType == 1)
         {
            g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
         }
        if(alienType == 2)
         {
            g.fillOval(getRect().x, getRect().y, getRect().width, getRect().height);
         }
         if(alienType == 3)
         {
             g.setColor(Color.pink);
            g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
         }
        
        }
        
//        setRect(getRect());  
    }

    /**
     * @return the c
     */
    public Color getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Color c) {
        this.c = c;
    }

    /**
     * @return the rect
     */
//    public Rectangle getRect() {
//        return rect;
//    }
//
//    /**
//     * @param rect the rect to set
//     */
//    public void setRect(Rectangle rect) {
//        this.rect = rect;
//    }
//    
    
}
