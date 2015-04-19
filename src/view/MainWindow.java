/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JPanel;
import mvc_bridgeway.screen.Screen;
import view.viewport.Viewport;

/**
 *
 * @author comcc_000: trivial change to test commit!
 */
public class MainWindow extends javax.swing.JFrame implements WindowFocusListener {

    /*Properties*/
    
    private Screen screen;
    
    /*Constructor*/
    
    public MainWindow() {
        initComponents();
        setExtendedState(Frame.MAXIMIZED_BOTH); //fullscreen
        //add the listeners that shouldn't even exist because WHY ORACLE!!!???
        addWindowFocusListener(this);
    }
    
    /**
     * Renders the display?
     * @param screen 
     */
    public void displayScreen(Screen screen) {
        this.screen = screen;
        Viewport view = screen.getViewport(this);
        
        setSize(view);
        this.getContentPane().removeAll();
        addViewport(view);
        
        pack();
        setExtendedState(Frame.MAXIMIZED_BOTH); //fullscreen
        setVisible(true);
    }
    
    public void addViewport(Viewport view) {
        this.getContentPane().add(view, BorderLayout.CENTER);
        view.updateUI();
    }
    
    public void setSize(Viewport view) {
        JPanel panel = view;
        int width = this.getWidth();
        int height = this.getHeight();
        panel.setBounds(0, 0, width, height); //x,y top right coordinate, then width, height
    }
    
    @Override
    public void windowGainedFocus(WindowEvent e) {
        screen.onFocusGained();
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        screen.onFocusLost();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
