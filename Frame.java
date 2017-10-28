/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.iu.student.demogame;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author nguye
 */
public class Frame extends JFrame{
    public Frame(){
        //setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setTitle("Plants VS Zombie ver 1.0");
        //Board board = new Board();
        
        
        
    }


}
