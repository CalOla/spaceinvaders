/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * File Name: GamePanel class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The GamePanel is the place where most of the activities of the
 * GamePanel takes place
 * The GamePanel serves as a canvas on which the properties of the other classes
 * are drawn
 * */
public class GamePanel extends JPanel implements  KeyListener
{
    private ArrayList<GameObject> gameObject;
    private SpaceShip spaceShip;
    private LaserCanon laserCanon;
    private Projectile projectile;
    private Timer projectileTimer;
    private Squadron squadron;
    private StatusPanel sp;
    private ControlPanel cp;
    
//    private Alien a;
    
    
    public GamePanel()
    {
        
        GameStart();
         /*
         addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
        gameObject = new ArrayList<>();
        spaceShip = new SpaceShip();
        laserCanon = new LaserCanon(0,550);
        projectile = new Projectile();
//        a = new Alien();
       
        squadron = new Squadron();
        
        projectileTimer = new Timer(3, new CanonTimerListener());
//        projectileTimer.start();
        */
    }
    
    public GamePanel(StatusPanel sp, ControlPanel cp)
    {
        this();
        this.sp = sp;
        this.cp = cp;
    }
    
    public void GameStart()
    {
        addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
        gameObject = new ArrayList<>();
        spaceShip = new SpaceShip();
        laserCanon = new LaserCanon(0,550);
        projectile = new Projectile();
//        a = new Alien();
       
        squadron = new Squadron();
        
        projectileTimer = new Timer(3, new CanonTimerListener());
        projectileTimer.start();
        System.out.println("woowo2");
    }
    
    
    
    
      
    /**
     * Adds a GameObject to the gameObjects arrayList
     * @param go
     */
    public void addGameObject(GameObject go)
    {
        gameObject.add(go);
    }
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        laserCanon.draw(g);
        projectile.draw(g);
        spaceShip.draw(g);
        squadron.draw(g);
        
        if(projectile.getRect().intersects(spaceShip.getRect()))
        {
            spaceShip.stopMoveTimer();
            spaceShip.startLaunchTimer();
            
            spaceShip.setVisible(false);
            spaceShip.setScorerX(spaceShip.getX());
            spaceShip.setScorerY(spaceShip.getY());
            spaceShip.setX(-80);
//            System.out.println("hello");
            projectile.setY(530);
            projectile.setMoveY(0);
            
            squadron.setScore(100);
            sp.setScore(squadron.getScore());
//            spaceShip.setX(650);
//            spaceShip.setY(0);
            
        }

        int row = 5;
        int column = 5;

            for(row = 0; row < squadron.getAliens().length; row++)
            {
                for(column = 0; column < squadron.getAliens()[row].length; column++)
                { 
//                   Alien a = new Alien();
                    
//                    aliens[row][column].getRect();
                    if((projectile.getRect().intersects(squadron.getAliens()[row][column].getRect())) &&(squadron.getAliens()[row][column].isVisible()))
                    {
//                        System.out.println("pow");
                        
                        projectile.setY(530);
                        projectile.setMoveY(0);
                        squadron.setScoreDisplay(1);
                        squadron.setScore(20);
                        System.out.println(squadron.getScore());
                        squadron.getAliens()[row][column].setVisible(false);
                        sp.setScore(squadron.getScore());
                    }
                }
            }
            
//        }
        
//        Sets the coordinate of the projectile
        if(projectile.getMoveY() == 0)
        {
            projectile.setX(laserCanon.getPnlWidth()+20);
        }
        
    }
    
    public void collision()
    {
        laserCanon.getLocation();
    }

    /**
     * @param i
     * @return the gameObject
     */
    public GameObject getGameObject(int i) {
        return gameObject.get(i);
    }

    /**
     * @param gameObj
     * @param i
     */
    public void setGameObject(GameObject gameObj, int i) {
        gameObject.set(i, gameObj);
    }

    /**
     * @return the spaceShip
     */
    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    /**
     * @param spaceShip the spaceShip to set
     */
    public void setSpaceShip(SpaceShip spaceShip) {
        spaceShip = new SpaceShip();
    }

    /**
     * @return the laserCanon
     */
    public LaserCanon getLaserCanon() {
        return laserCanon;
    }

    /**
     * @param laserCanon the laserCanon to set
     */
    public void setLaserCanon(LaserCanon laserCanon) {
        laserCanon = new LaserCanon(8, 7);
    }

    /**
     * @return the projectile
     */
    public Projectile getProjectile() {
        return projectile;
    }

    /**
     * @param projectile the projectile to set
     */
    public void setProjectile(Projectile projectile) {
        projectile = new Projectile();
    }

    /**
     * @return the projectileTimer
     */
    public Timer getProjectileTimer() {
        return projectileTimer;
    }

    /**
     * @param projectileTimer the projectileTimer to set
     */
    public void setProjectileTimer(Timer projectileTimer) {
        projectileTimer = new Timer(5, null);
    }

    /**
     * @return the squadron
     */
    public Squadron getSquadron() {
        return squadron;
    }

    /**
     * @param squadron the squadron to set
     */
    public void setSquadron(Squadron squadron) {
        this.squadron = squadron;
    }
    
    class CanonTimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
                laserCanon.fireCanon();
                repaint();

        }
    }
    
        public void keyPressed(KeyEvent e)
        {
//            System.out.println("Position of canon "+projectile.getX()+"  " + projectile.getY());
            
            int c = e.getKeyCode();
            int k   =0;
//            fires the laser canon upwards
            if(c == KeyEvent.VK_SPACE)
            {
                k = projectile.getX();
//                System.out.println("Gamepanel "+projectile.getX()+"  "+k);
            
                projectile.setMoveY(1);

            }
            
//          lets the laser canon move in the right direction
            if(c == KeyEvent.VK_RIGHT)
            {
                laserCanon.setMoveX(1);

            }
            
//          lets the laser canon move in the left direction
            if(c == KeyEvent.VK_LEFT)
            {
                laserCanon.setMoveX(-1);

            }
            
        }
        public void keyReleased(KeyEvent e)
        {
            int c = e.getKeyCode();
          
//            Lets the laser canon move just 1 unit in the right direction
            if(c == KeyEvent.VK_RIGHT)
            {
                laserCanon.setMoveX(0);

            }
            
//            Lets the laser canon move just 1 unit in the left direction
            if(c == KeyEvent.VK_LEFT)
            {
                laserCanon.setMoveX(0);
            }
            
        }
        public void keyTyped(KeyEvent e)
        {
            
            
        }
    
    
}
