/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;

/**
 * File Name: GamePanel class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The LaserCanon class holds the projectile and moves with the
 * help of the action listeners
 * */
public class LaserCanon extends GameObject
{
    private int pnlWidth;
    private int pnlHeight;
    private int moveLcn;
    private int moveX;
    
    public LaserCanon(int pnlW, int pnlH)
    {
        super();
        moveLcn = 0;
        pnlWidth = pnlW;
        pnlHeight = pnlH;
        moveX = 0;
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillRect(pnlWidth, pnlHeight, 50, 50);
    }

    /**
     * @return the pnlWidth
     */
    public int getPnlWidth() {
        return pnlWidth;
    }

    /**
     * @param pnlWidth the pnlWidth to set
     */
    public void setPnlWidth(int pnlWidth) {
        this.pnlWidth = pnlWidth;
    }

    /**
     * @return the pnlHeight
     */
    public int getPnlHeight() {
        return pnlHeight;
    }

    /**
     * @param pnlHeight the pnlHeight to set
     */
    public void setPnlHeight(int pnlHeight) {
        this.pnlHeight = pnlHeight;
    }

    /**
     * @return the moveInc
     */
    public int getMoveLcn() {
        return moveLcn;
    }

    /**
     * @param moveLcn the moveInc to set
     */
    public void setMoveLcn(int moveLcn) 
    {
        this.moveLcn = moveLcn;
    }
    
    
    public void fireCanon() {


        if(pnlHeight < 0)
        {
            pnlHeight = 0;
            moveX = 0;
        }
        if(pnlHeight > 550)
        {
            moveLcn = -1;
            pnlHeight = 550;
            moveX = 0;
        }
        if(pnlWidth > 550)
        {
            moveLcn = 0;
            pnlWidth = 550;
            moveX = 0;
        }
        if(pnlWidth < 0)
        {
            pnlWidth = 0;
            moveLcn = 0;
            moveX = 0;
        }
        if((moveX == -1) && (moveLcn == 0))
        {
            moveLcn = 0;
        }
        if((moveX == 1) && (moveLcn == 0))
        {
            moveLcn = 0;
        }
        

        pnlWidth += moveX;
        pnlHeight += moveLcn;  
    }

    /**
     * @return the moveX
     */
    public int getMoveX() {
        return moveX;
    }

    /**
     * @param moveX the moveX to set
     */
    public void setMoveX(int moveX) {
        this.moveX = moveX;
        
    }
}
