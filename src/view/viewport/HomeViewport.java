/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import model.ModelViewBundle;
import mvc_bridgeway.command.model_command.ExitCommand;
import mvc_bridgeway.command.model_command.LaunchScreenCommand;
import mvc_bridgeway.command.model_command.LoadCommand;
import mvc_bridgeway.control.virtual_control.swing_control.ButtonSwingControl;
import mvc_bridgeway.control_map.ControlMap;
import mvc_bridgeway.screen.NewGameScreen;
import utility.ImageUtil;

/**
 *
 * @author comcc_000
 */
public class HomeViewport extends Viewport {

    /**
     * Creates new form MainScreen
     */
    public HomeViewport() {
        initComponents();
    }
    
    @Override
    protected void generateView() {
        //no need in this case
    }
    
    @Override
    public void update(ModelViewBundle mvb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        controlMaps.add(new ControlMap(new ButtonSwingControl(newGameButton), new LaunchScreenCommand(new NewGameScreen()))); 
        controlMaps.add(new ControlMap(new ButtonSwingControl(exitButton), new ExitCommand()));
        controlMaps.add(new ControlMap(new ButtonSwingControl(loadButton), new LoadCommand()));
        return controlMaps;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        newGameButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        newGameButton.setText("New Game");
        jPanel1.add(newGameButton, java.awt.BorderLayout.CENTER);

        loadButton.setText("Load");
        loadButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(loadButton, java.awt.BorderLayout.PAGE_START);

        exitButton.setText("Exit");
        jPanel1.add(exitButton, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel1, new java.awt.GridBagConstraints());

        jLayeredPane1.add(jPanel3);
        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.POPUP_LAYER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/gif/main_menu_bg.gif"))); // NOI18N
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLayeredPane1.add(jPanel2);

        add(jLayeredPane1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newGameButton;
    // End of variables declaration//GEN-END:variables
  
}
