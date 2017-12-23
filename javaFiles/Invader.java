/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Graphics;
import java.util.Random;

/**
 * File Name: GameObject class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The Invader class extends the GameObject class
 * The Invader class serves as the super class for all the enemies in the
 * Space Invaders
 * The Space Invader has a no argument constructor that calls the constructor of 
 * its super class.
 */
public abstract class Invader extends GameObject
{
    private int pointValue;
    private int speed;
    private int direction;
    private int height;
    private int width;
    private Random rand;
    
    public Invader()
    {
        super();
        rand = new Random();
    }

    /**
     * @return the pointValue
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * @param pointValue the pointValue to set
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
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

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the rand
     */
    public Random getRand() {
        return rand;
    }

    /**
     * @param rand the rand to set
     */
    public void setRand(Random rand) {
        this.rand = rand;
    }
    
    @Override
    public abstract void draw(Graphics g);
    
    
}
