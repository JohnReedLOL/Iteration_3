/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.util.ArrayList;
import model.ModelViewBundle;
import model.armory.Armory;
import model.entity.avatar.Avatar;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.occupation.SmasherOccupation;
import model.entity.occupation.SneakOccupation;
import model.entity.occupation.SummonerOccupation;
import model.inventory.Sack;
import mvc_bridgeway.command.model_command.LaunchScreenCommand;
import mvc_bridgeway.command.model_command.SetOccupationCommand;
import mvc_bridgeway.control.virtual_control.swing_control.ButtonSwingControl;
import mvc_bridgeway.control_map.ControlMap;
import mvc_bridgeway.screen.GameScreen;

/**
 *
 * @author comcc_000
 */
public class NewGameViewport extends Viewport {

    /**
     * Creates new form MainScreen
     */
    public NewGameViewport() {
        initComponents();
    }
    !
    @Override
    protected void generateView() {
        //TODO
    }
    
    @Override
    public void update(ModelViewBundle mvb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
            controlMaps.add(new ControlMap(new ButtonSwingControl(smasher_button_), new SetOccupationCommand(new Avatar("Smasher", "Smasher Desc", new Armory(), new Sack(), null, ClassicMovementBehavior.getInstance()), new SmasherOccupation()), new LaunchScreenCommand(new GameScreen())));
            controlMaps.add(new ControlMap(new ButtonSwingControl(sneak_button_), new SetOccupationCommand(new Avatar("Sneak", "Sneak Desc", new Armory(), new Sack(), null, ClassicMovementBehavior.getInstance()), new SneakOccupation()), new LaunchScreenCommand(new GameScreen())));
            controlMaps.add(new ControlMap(new ButtonSwingControl(summoner_button_), new SetOccupationCommand(new Avatar("Summoner", "Summoner Desc", new Armory(), new Sack(), null, ClassicMovementBehavior.getInstance()), new SummonerOccupation()), new LaunchScreenCommand(new GameScreen())));
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
        sneak_button_.setText("Sneak");
        add(sneak_button_);

        smasher_button_.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        smasher_button_.setText("Smasher");
        add(smasher_button_);

        summoner_button_.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        summoner_button_.setText("Summoner");
        add(summoner_button_);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton smasher_button_;
    private javax.swing.JButton sneak_button_;
    private javax.swing.JButton summoner_button_;
    // End of variables declaration//GEN-END:variables
  
}
