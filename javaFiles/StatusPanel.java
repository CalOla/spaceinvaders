/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * File Name: GamePanel class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The StatusPanel displays the current states and activities of the game
 * */
public class StatusPanel extends JPanel
{
    JLabel lb;
    private Squadron sq;
    
    public StatusPanel()
    {
        sq = new Squadron();
        sq.getScore();
        lb = new JLabel();
        add(lb);
    }
    
    public void setScore(int i)
    {
        lb.setText("Score: " + i);
    }
    
    
    
}
