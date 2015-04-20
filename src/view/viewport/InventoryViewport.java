/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import application.Application;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import model.ModelViewBundle;
import model.item.oneshot.OneShotItem;
import model.item.sackbound.SackboundItem;
import mvc_bridgeway.command.model_command.ExitCommand;
import mvc_bridgeway.control.virtual_control.swing_control.SwingControl;
import mvc_bridgeway.control_map.ControlMap;
import view.utility.JButtonObjectRenderer;

/**
 *
 * @author comcc_000
 */
public class InventoryViewport extends Viewport {

    private final JButtonObjectRenderer buttonRenderer_ = new JButtonObjectRenderer();
    private final ModelViewBundle mvb_ = ModelViewBundle.getInstance();
    private final List<SackboundItem> items_ = mvb_.getInventory();

    /**
     * Creates new form MainScreen
     */
    public InventoryViewport() {
        initComponents();
        items_.add(new SackboundItem());
    }

    @Override
    protected void generateView() {
        //TODO
    }

    @Override
    public void update(ModelViewBundle mvb) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        //TODOD
        return controlMaps;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        if(items_.size() == 0) {
            Application.print("Inventory is empty");
            return;
        }
        Application.print("Size of inventory is: " + items_.size());
        if (item_1_ != null && items_.size() >= 1) {
            Application.print("Size of inventory is >= 1");
            buttonRenderer_.setButtonForMeToRenderTo(item_1_);
            items_.get(0).accept(buttonRenderer_);
        }
        if (item_2_ != null && items_.size() >= 2) {
            Application.print("Size of inventory is >= 2");
            buttonRenderer_.setButtonForMeToRenderTo(item_2_);
            items_.get(1).accept(buttonRenderer_);
        }
        if (item_3_ != null && items_.size() >= 3) {
            buttonRenderer_.setButtonForMeToRenderTo(item_3_);
            items_.get(2).accept(buttonRenderer_);
        }
        if (item_4_ != null && items_.size() >= 4) {
            buttonRenderer_.setButtonForMeToRenderTo(item_4_);
            items_.get(3).accept(buttonRenderer_);
        }
        if (item_5_ != null && items_.size() >= 5) {
            buttonRenderer_.setButtonForMeToRenderTo(item_5_);
            items_.get(4).accept(buttonRenderer_);
        }
        if (item_6_ != null && items_.size() == 6) {
            buttonRenderer_.setButtonForMeToRenderTo(item_6_);
            items_.get(5).accept(buttonRenderer_);
        }
        
        Application.check(items_.size() <= 7);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        item_2_ = new javax.swing.JButton();
        item_1_ = new javax.swing.JButton();
        item_4_ = new javax.swing.JButton();
        item_3_ = new javax.swing.JButton();
        item_6_ = new javax.swing.JButton();
        item_5_ = new javax.swing.JButton();

        item_2_.setText("Item 2");

        item_1_.setText("Item 1");

        item_4_.setText("Item 4");

        item_3_.setText("Item 3");

        item_6_.setText("Item 6");

        item_5_.setText("Item 5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_3_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_5_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_1_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_4_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_2_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_6_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_1_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_2_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_3_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_4_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_6_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_5_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton item_1_;
    private javax.swing.JButton item_2_;
    private javax.swing.JButton item_3_;
    private javax.swing.JButton item_4_;
    private javax.swing.JButton item_5_;
    private javax.swing.JButton item_6_;
    // End of variables declaration//GEN-END:variables

}
