/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.util.ArrayList;
import model.ModelViewBundle;
import mvc_bridgeway.command.model_command.ExitCommand;
import mvc_bridgeway.control.virtual_control.SwingControl;
import mvc_bridgeway.control_map.ControlMap;

/**
 *
 * @author comcc_000
 */
public class SkillsViewport extends Viewport {

    /**
     * Creates new form MainScreen
     */
    public SkillsViewport() {
        initComponents();
    }
    
    @Override
    protected void generateView() {
        //TODO
    }
    
    @Override
    public void update(ModelViewBundle mvb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        //TODOD
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        skill1_ = new javax.swing.JButton();
        skill2_ = new javax.swing.JButton();
        skill4_ = new javax.swing.JButton();
        skill3_ = new javax.swing.JButton();
        skill5_ = new javax.swing.JButton();
        skill6_ = new javax.swing.JButton();
        skill7_ = new javax.swing.JButton();

        skill1_.setText("Skill 1");

        skill2_.setText("Skill 2");
        skill2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skill2_ActionPerformed(evt);
            }
        });

        skill4_.setText("Skill 4");

        skill3_.setText("Skill 3");

        skill5_.setText("Skill 5");

        skill6_.setText("Skill 6");

        skill7_.setText("Skill 7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(skill7_)
                    .addComponent(skill6_)
                    .addComponent(skill5_)
                    .addComponent(skill4_)
                    .addComponent(skill2_)
                    .addComponent(skill1_)
                    .addComponent(skill3_))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(skill1_)
                .addGap(35, 35, 35)
                .addComponent(skill2_)
                .addGap(29, 29, 29)
                .addComponent(skill3_)
                .addGap(30, 30, 30)
                .addComponent(skill4_)
                .addGap(32, 32, 32)
                .addComponent(skill5_)
                .addGap(33, 33, 33)
                .addComponent(skill6_)
                .addGap(29, 29, 29)
                .addComponent(skill7_)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void skill2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skill2_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skill2_ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton skill1_;
    private javax.swing.JButton skill2_;
    private javax.swing.JButton skill3_;
    private javax.swing.JButton skill4_;
    private javax.swing.JButton skill5_;
    private javax.swing.JButton skill6_;
    private javax.swing.JButton skill7_;
    // End of variables declaration//GEN-END:variables
  
}
