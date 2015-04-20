/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.util.ArrayList;
import model.ModelViewBundle;
import model.entity.ConversationNode;
import mvc_bridgeway.control_map.ControlMap;

/**
 *
 * @author comcc_000
 */
public class TextConsoleViewport extends Viewport {

    /**
     * Creates new form MainScreen
     */
    public TextConsoleViewport() {
        initComponents();
        renderCurrentConversationNode(new ConversationNode("Welcome to the world", 
                "Eat fish", "Dance", "Who are you?", "I'm ready for you, world."));
    }

    @Override
    protected void generateView() {
        //TODO
    }

    @Override
    public void update(ModelViewBundle mvb) {
        incoming_chat_.setText(mvb.getCurrentDialogue());
//        incoming_chat_.append("\n" + n.getMyReplyToWhatYouSaidToMe_() + "\n");
    }

    public void renderCurrentConversationNode(ConversationNode n) {
        incoming_chat_.append("\n" + n.getMyReplyToWhatYouSaidToMe_() + "\n");
        incoming_chat_.append("Press 0: " + n.getYourFirstReplyOption_() + "\n");
        incoming_chat_.append("Press 1: " + n.getYourSecondReplyOption_() + "\n");
        incoming_chat_.append("Press 2: " + n.getYourThirdReplyOption_() + "\n");
        incoming_chat_.append("Press 3: " + n.getYourFourthReplyOption_() + "\n");
        incoming_chat_.append("\n");
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        //TODOD
        return controlMaps;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outgoing_chat_ = new javax.swing.JTextField();
        incoming_chat_scroll_pane = new javax.swing.JScrollPane();
        incoming_chat_ = new javax.swing.JTextArea();

        outgoing_chat_.setText("outgoing_chat_");

        incoming_chat_.setEditable(false);
        incoming_chat_.setColumns(20);
        incoming_chat_.setRows(5);
        incoming_chat_.setText("incoming_chat_");
        incoming_chat_scroll_pane.setViewportView(incoming_chat_);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outgoing_chat_)
            .addComponent(incoming_chat_scroll_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(incoming_chat_scroll_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outgoing_chat_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea incoming_chat_;
    private javax.swing.JScrollPane incoming_chat_scroll_pane;
    private javax.swing.JTextField outgoing_chat_;
    // End of variables declaration//GEN-END:variables

}
