/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.iu.student.demogame;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author nguye
 */
public class Screen extends JFrame{
    public Screen(){
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
  
   /* public static void main(String[] args) {
        Screen screen = new Screen();
}*/
}
