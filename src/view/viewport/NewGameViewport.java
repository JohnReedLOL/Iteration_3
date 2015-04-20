/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.ModelViewBundle;
import mvc_bridgeway.command.model_command.*;
import mvc_bridgeway.control.virtual_control.swing_control.ButtonSwingControl;
import mvc_bridgeway.control_map.ControlMap;
import mvc_bridgeway.screen.GameScreen;
import utility.ImageUtil;

/**
 *
 * @author comcc_000
 */
public class NewGameViewport extends Viewport {

    private boolean runAtLeastOnce = false;
    
    public NewGameViewport() {
        initComponents();
    }

    @Override
    protected void generateView() {
        int margin = 200;
        setupButton("./src/resources/png/sorority_girl.png", sneak_button_, margin);
        setupButton("./src/resources/png/frat_boy.png", smasher_button_, margin);
        setupButton("./src/resources/png/nerd.png", summoner_button_, margin);
    }
    
    private void setupButton(String filepath, JButton button, int margin) {
        Image image = ImageUtil.getImage(filepath);
        image = ImageUtil.scaleImage(image, button.getWidth() - margin, button.getHeight() - margin);
        button.setIcon(new ImageIcon(image));
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setFont(new Font("Arial", Font.PLAIN, 40));
        button.setIconTextGap(0);
    }
    
    @Override
    public void update(ModelViewBundle mvb) {
        if (!runAtLeastOnce) {
            generateView();
            runAtLeastOnce = true;
        }
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
            controlMaps.add(new ControlMap(new ButtonSwingControl(smasher_button_), new SetSmasherOccupationCommand(), new LaunchScreenCommand(new GameScreen())));
            controlMaps.add(new ControlMap(new ButtonSwingControl(sneak_button_), new SetSneakOccupationCommand(), new LaunchScreenCommand(new GameScreen())));
            controlMaps.add(new ControlMap(new ButtonSwingControl(summoner_button_), new SetSummonerOccupationCommand(), new LaunchScreenCommand(new GameScreen())));
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

        sneak_button_ = new javax.swing.JButton();
        smasher_button_ = new javax.swing.JButton();
        summoner_button_ = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(1, 3));

        sneak_button_.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sneak_button_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/png/sneak_S.png"))); // NOI18N
        sneak_button_.setText("Sneak");
        add(sneak_button_);

        smasher_button_.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        smasher_button_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/png/smasher_S.png"))); // NOI18N
        smasher_button_.setText("Smasher");
        add(smasher_button_);

        summoner_button_.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        summoner_button_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/png/summoner_S.png"))); // NOI18N
        summoner_button_.setText("Summoner");
        add(summoner_button_);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton smasher_button_;
    private javax.swing.JButton sneak_button_;
    private javax.swing.JButton summoner_button_;
    // End of variables declaration//GEN-END:variables
  
}
