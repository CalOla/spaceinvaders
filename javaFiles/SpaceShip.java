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
import java.util.Random;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 * File Name: SpaceShip class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The SpaceShip class draw and controls the movement of the spaceship
 * 
 * */
public class SpaceShip extends Invader
{
    private Timer moveTimer;
    private Timer launchTimer;
    private Timer scoreDisplayTimer;
    private GamePanel gamePanel;
    private Random rand;
    private int xmove;
    private int r;
    private int scorer;
    private int scorerX;
    private int scorerY;
    
    public SpaceShip()
    {
        super();
        moveTimer = new Timer(20, new MoveController());
        moveTimer.start();
        
        scoreDisplayTimer = new Timer(3000, new ScoreController());
        
        launchTimer = new Timer(7000, new LaunchController());

        rand = new Random();
        scorer = 0;
        
        xmove = 1;
         r = 0;
         
         setX(-80);
        
        
    }
    
    public void startMoveTimer()
    {
        moveTimer.start();
    }
    
    public void stopMoveTimer()
    {
        moveTimer.stop();
    }
    
    public void startLaunchTimer()
    {
        launchTimer.start();
    }
    
    public void stopLaunchTimer()
    {
        launchTimer.stop();
    }
   
    @Override
    public void draw(Graphics g)
    {
        
        if(!this.isVisible())
        {
            g.setColor(Color.red);
            scoreDisplayTimer.start();
            g.drawString("100", getScorerX()+10, getScorerY()+35); 
        }
        
        Rectangle rect = new Rectangle(getX(), getY(), 80, 50);
        g.setColor(Color.yellow);
        
        
      if(this.isVisible())
        {
        g.fillOval(rect.x, rect.y, rect.width, rect.height);
        // if all the way left and moving left.
        if((getX() <= -80) && (r == 2))
        {
            stopMoveTimer();
        }
        if((getX() > 600)&&(r==1))
        {
            stopMoveTimer();
        }
        
        }
      setRect(rect);
        
  
    }
    
    public int generate()
    {
        r = rand.nextInt(2)+1;
        System.out.println(r);
             if(!this.isVisible())
        {
            
            this.setVisible(true);
            
        }
        startMoveTimer();
        return r;
    }
    
    public int mover()
    {
//        System.out.println("x is: " + getX());
        
        if(r == 1)
        {

             setX(getX()+xmove);
        }
        else if(r == 2)
        {

            setX(getX()-xmove);
        }
        
        
        if((getX() > 600) || (getX() <= -80))
        {
           startLaunchTimer();
        }
        else if((getX() > -80) || (getX()< 600))
        {
           stopLaunchTimer();
        }
        
        
        
        return r;
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

    /**
     * @return the scorer
     */
    public int getScorer() {
        return scorer;
    }

    /**
     * @param scorer the scorer to set
     */
    public void setScorer(int scorer) {
        this.scorer = scorer;
    }

    /**
     * @return the scorerX
     */
    public int getScorerX() {
        return scorerX;
    }

    /**
     * @param scorerX the scorerX to set
     */
    public void setScorerX(int scorerX) {
        this.scorerX = scorerX;
    }

    /**
     * @return the scorerY
     */
    public int getScorerY() {
        return scorerY;
    }

    /**
     * @param scorerY the scorerY to set
     */
    public void setScorerY(int scorerY) {
        this.scorerY = scorerY;
    }

    /**
     * @return the scoreDisplayTimer
     */
    public Timer getScoreDisplayTimer() {
        return scoreDisplayTimer;
    }

    /**
     * @param scoreDisplayTimer the scoreDisplayTimer to set
     */
    public void setScoreDisplayTimer(Timer scoreDisplayTimer) {
        this.scoreDisplayTimer = scoreDisplayTimer;
    }
    
    class LaunchController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            generate();
        }
    }
    
    class MoveController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            mover();
        }
    }
    class ScoreController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            setScorerX(-150);
        }
    }
}
