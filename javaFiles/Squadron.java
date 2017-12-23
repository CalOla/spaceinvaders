/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * File Name: Squadron class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The Squadrons are the group of aliens
 * moving back and forth in the game
 * */
public class Squadron 
{
    private int row;
    private int column;
    private Alien[][] aliens;
//    private Alien[][] aliens ;
//    private Direction direction;
    private Timer moveTimer;
    private int numVisible;
    private GamePanel gamePanel;
    private int xmove;
    private int ymove;
    private Alien a;
    int x;
    int  k;
    private int  scoreDisplay;
    private int  score;
    
    public Squadron()
    {
        moveTimer = new Timer(15, new MoveController());
        moveTimer.start();
        row = 5;
        column = 5;
        aliens = new Alien [row][column];
        x =0;
        k = 0;
        xmove = 1;
        ymove = 0;
        scoreDisplay = 0;
        score = 0;
//        a = new Alien();
        for(row = 0; row < aliens.length; row++)
        {  
            for(column = 0; column < aliens[row].length; column++)
            {
                
                a = new Alien();
                a.setX((row * 40));
                a.setY(column *40);
                aliens[row][column] = a;
//                aliens[row][column].setRect(new Rectangle(aliens[row][column].getX(), aliens[row][column].getY(), 30, 30));
//                System.out.println("hello");
//                System.out.println(a.getRect());
            }
        }
        
        
    }
    
    

    /**
     * @return the aliens
     */
    public Alien[][] getAliens() {
        return aliens;
    }

    /**
     * @param aliens the aliens to set
     */
    public void setAliens(Alien[][] aliens) {
        this.aliens = aliens;
    }

    /**
     * @return the moveTimer
     */
    public Timer getMoveTimer() {
        return moveTimer;
    }

    /**
     * @param moveTimer the moveTimer to set
     */
    public void setMoveTimer(Timer moveTimer) {
        this.moveTimer = moveTimer;
    }

    /**
     * @return the numVisible
     */
    public int getNumVisible() {
        return numVisible;
    }

    /**
     * @param numVisible the numVisible to set
     */
    public void setNumVisible(int numVisible) {
        this.numVisible = numVisible;
    }
    
    /**
     *
     * @param g
     */
    public void draw(Graphics g)
    {

        g.setColor(Color.green);
        
        
        for(row = 0; row < aliens.length; row++)
        {
       
            for(column = 0; column < aliens[row].length; column++)
            { 
                aliens[row][column].setAlienType(3);
                
//                if(row == 1)
//                {
                    aliens[row][column].draw(g);
//                }
//                if(row == 2)
//                {
//                    aliens[row][column].draw(g);
//                }
 
            }

        }
    }
    
    public void mover()
    {
        for(row = 0; row < aliens.length; row++)
        {

            for(column = 0; column < aliens[row].length; column++)
            { 
                if(aliens[row][column].isVisible())
                {
                    if(aliens[row][column].getX() > 570)
                    {              
                        ymove =20;
                        xmove = -1;
                    }
                    if(aliens[row][column].getX() < 0)
                    {
                        ymove = 20;
                        xmove = 1;
                    }

//                     aliens[row][column].setX(aliens[row][column].getX()+ xmove);

                }
            }
        }
        
        for(row = 0; row < aliens.length; row++)
        {

            for(column = 0; column < aliens[row].length; column++)
            { 
                     aliens[row][column].setX(aliens[row][column].getX()+ xmove);
                     aliens[row][column].setY(aliens[row][column].getY()+ ymove);
                    
            }
        }
        ymove = 0;

    }

    /**
     * @return the scorer
     */
    public int getScoreDisplay() {
        return scoreDisplay;
    }

    /**
     * @param scorer the scorer to set
     */
    public void setScoreDisplay(int scorer) {
        this.scoreDisplay = scorer;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score + getScore();
    }
    
    class MoveController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
//            xmove += 1;
          
            mover();
//            System.out.println("here");
            
        }
    }

    /**
     * @return the gamePanel
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * @param gamePanel the gamePanel to set
     */
    public void setGamePanel(GamePanel gamePanel) {
        gamePanel = new GamePanel();
    }
}
