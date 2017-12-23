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
 * File Name: Projectile class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The Projectile class extends the GameObject
 * The projectile uses the x and y coordinates of the Laser Canon
 * to determine its position, and once its fired it maintains the x-coordinates
 * The coordinates destroys the space ship or laser canon on intersection
 */
public class Projectile extends GameObject
{
    private int speed;
 
    private int ymove;
    private int xmove;
    
    public Projectile()
    {
        super();
        speed = 0;
        
        ymove = 0;
        xmove =1;
        setY(530);
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.blue);
        Rectangle rect = new Rectangle(getX(), getY(), 10, 20);
        setRect(rect);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
//        System.out.println("hello");
        
        if(getY() <= 0)
        {
            setY(530);
//            g.fillRect(getX(), getY(), 10, 20);
            setMoveY(0);
        }
//        if(getY() > 590)
//        {
//            setY(590);
//        }
//        System.out.println(getX());
        setY(getY()-getMoveY());
    }
    public void setMoveX(int x)
    {
        this.setX(x);
    }
    public int getMoveX()
    {
        return getX();
    }
    public void setMoveY(int ymove)
    {
        this.ymove = ymove;
    }
    public int getMoveY()
    {
        return ymove;
    }
}
