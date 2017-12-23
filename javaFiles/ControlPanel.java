/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * File Name: GamePanel class 
 * Author: Caleb Olaoye
 * Course and Section: GEEN 165 002
 * Date: 11-23-2015
 * Description: The ControlPanel is the control center for the main activities of the game
 * */
public class ControlPanel extends JPanel
{
    JButton b;
    private int i;
    private GamePanel gp;

    public ControlPanel()
    {
        gp = new GamePanel();
        i =0;
//        JLabel l = new JLabel("Space Invaders");
//        add(l);
//        setLayout(new GridLayout(3,1,5,5));
        b = new JButton("Start");
        add(b);
        b.addActionListener(new ControlListener());
        b = new JButton("Restart");
        add(b);
        b.addActionListener(new ControlListener());
        b = new JButton("Exit");
        add(b);
        b.addActionListener(new ControlListener());
        
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @param i the i to set
     */
    public void setI(int i) {
        this.i = i;
    }
    
    public void setStart()
    {
        
    }
   
    private class ControlListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton btn = (JButton) e.getSource();
            
            if(btn.getText().equals("Start"))
            {
//                System.out.println("Hello");
                gp.GameStart();
//                setI(1);
//                System.out.println(getI());
            }
            if(btn.getText().equals("Restart"))
            {
                System.out.println("re");
            }
            if(btn.getText().equals("Exit"))
            {
                System.exit(0);
            }
        }
    }
    
    public void setScore(int i)
    {
        ;
    }
}
