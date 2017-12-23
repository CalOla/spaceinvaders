/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * File Name: GameObject class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The GameObject class serves as the super class for most of the
 * classes in the SpaceInvaders project
 * The GameObject class has a no argument constructor that initializes the visibility
 * and location
 * The GameObject class has another constructor that takes a boolean, Point and 
 * color values
 */
public abstract class GameObject
{
    private boolean visible;
    private Point location;
    private Color color;
    private Rectangle rect;
//    private int x,y;
    
    public GameObject()
    {
        visible = true;
        location = new Point(0, 0);
    }
    
    public GameObject(boolean visibility, Point locate, Color colour)
    {
        visible = visibility;
        location = locate;
        color = colour;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Abstract method draw
     * @param g
     */
    public abstract void draw(Graphics g);

    /**
     * @return the x
     */
    public int getX() {
        return location.x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        location.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return location.y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        location.y = y;
    }

    /**
     * @return the rect
     */
    public Rectangle getRect() {
        return rect;
    }

    /**
     * @param rect the rect to set
     */
    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}
