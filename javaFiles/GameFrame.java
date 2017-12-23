/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * File Name: GameFrame class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The GameFrame class serves as the window, It contains all the 
 * panels in the SpaceInvaders project and adds them in a orderly manner
 */
public class GameFrame extends JFrame
{
    private StatusPanel sp = new StatusPanel();
    private ControlPanel controlP = new ControlPanel();
    private GamePanel gamePanel = new GamePanel(sp,controlP);
    
    private int i =0;
    
    public GameFrame()
    {
//        setBackground(Color.yellow);
//        JLabel l = new JLabel();
//        l.setBackground(Color.yellow);
        
        
        add(controlP, BorderLayout.SOUTH);
        int k = controlP.getI();
        if(k == 0)
        {
            gamePanel.setBackground(Color.black);
            add(gamePanel,BorderLayout.CENTER);
            System.out.println(controlP.getI()+ "jkhjgghj");
        }
        sp.setScore(0);
        add(sp, BorderLayout.NORTH);
        
    }
    
}
