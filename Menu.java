/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.iu.student.demogame;

import javax.swing.*;

/**
 *
 * @author nguye
 */
public class Menu {

    public Menu() {
        Button button = new Button();
        
    }

        
    public class Button extends JButton {
    
    public Button() {
       Frame frame = new Frame();
        JButton button = new JButton("Play");
        button.setBounds(1000, 250, 300, 50);
        button.setVisible(true);
        //button.doClick();
        frame.add(button);
        frame.setLayout(null);
         JButton button2 = new JButton("Credit");
        button2.setBounds(1000, 300, 300, 50);
        button2.setVisible(true);
        //button.doClick();
        frame.add(button2);
        frame.setLayout(null); 
        
       
    }
}
}

