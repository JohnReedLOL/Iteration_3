/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outermost_Package.View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author JohnReedLOL
 */
public class Game_Screen_JPanel extends JPanel {
    public Game_Screen_JPanel() {
        super();
        
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        g.drawString("Custom Game_Screen_JPanel!",10,20);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }  
}
