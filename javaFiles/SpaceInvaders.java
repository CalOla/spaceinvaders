/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import javax.swing.JFrame;

/**
 * File Name: Space Invaders
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The SpaceInvaders class serves as the main class for all the other classes in the project
 * 
 */
 
public class SpaceInvaders 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        GameFrame jf = new GameFrame();

        jf.setSize(600, 660);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.add(pnl); 
    }
    
}
