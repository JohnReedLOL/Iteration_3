/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import application.Application;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import model.ModelViewBundle;
import model.armory.Armory;
import model.entity.Entity;
import model.entity.avatar.Avatar;
import model.entity.stats.SmasherStats;
import model.entity.stats.SmasherStatsVisitor;
import model.entity.stats.SneakStats;
import model.entity.stats.SneakStatsOwnership;
import model.entity.stats.SneakStatsVisitor;
import model.entity.stats.Stats;
import model.entity.stats.StatsOwnership;
import model.entity.stats.StatsVisitor;
import model.entity.stats.SummonerStats;
import model.entity.stats.SummonerStatsVisitor;
import model.inventory.Sack;
import mvc_bridgeway.command.model_command.ExitCommand;
import mvc_bridgeway.control.virtual_control.swing_control.SwingControl;
import mvc_bridgeway.control_map.ControlMap;

/**
 *
 * @author comcc_000
 */
public class StatsViewport extends Viewport implements StatsVisitor, SneakStatsVisitor, SummonerStatsVisitor, SmasherStatsVisitor {

    final Avatar mocAvatar_ = new Avatar(null);

    /**
     * Creates new form MainScreen
     */
    public StatsViewport() {
        // TODO: 

        //
        initComponents();
        stats_jTextPane_.setEditable(false);
        renderAllStats(mocAvatar_);
    }

    public void renderAllStats(Avatar a) {
        stats_jTextPane_.setText("");
        stats_jTextPane_.setText("Stats:\n");
        StyledDocument doc = stats_jTextPane_.getStyledDocument();

        //  Define a keyword attribute
        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        StyleConstants.setForeground(keyWord, Color.RED);
        StyleConstants.setBackground(keyWord, Color.YELLOW);
        StyleConstants.setBold(keyWord, true);

        //  Add some text
        try {
            //doc.insertString(0, "Start of text\n", null);
            doc.insertString(doc.getLength(), "Start of stats (new moc avatar created):\n", null);

            doc.insertString(doc.getLength(), "Skill points:" + mocAvatar_.getStatsOwnership().getSkillPoints(), null);
            doc.insertString(doc.getLength(), "Stats points:" + mocAvatar_.getStatsOwnership().getStatPoints(), null);
            renderStats(mocAvatar_.getStatsOwnership().getStats(), doc, keyWord);
            doc.insertString(doc.getLength(), "\nEnd of stats", keyWord);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void renderStats(Stats s, StyledDocument doc, SimpleAttributeSet keyWord) {
        try {
            doc.insertString(doc.getLength(), "Affinity: " + s.getAffinity(), null);
            doc.insertString(doc.getLength(), "Agility: " + s.getAgility(), null);
            doc.insertString(doc.getLength(), "Armor: " + s.getArmor(), null);
            doc.insertString(doc.getLength(), "Armor Modifier: " + s.getArmorModifier(), null);
            doc.insertString(doc.getLength(), "Bargain: " + s.getBargain(), null);
            doc.insertString(doc.getLength(), "Bind Wounds: " + s.getBindWounds(), null);
            doc.insertString(doc.getLength(), "CurrentLife: " + s.getCurrentLife(), null);
            doc.insertString(doc.getLength(), "CurrentMana: " + s.getCurrentMana(), null);
            doc.insertString(doc.getLength(), "Defense: " + s.getDefense(), null);
            doc.insertString(doc.getLength(), "Experience: " + s.getExperience(), null);
            doc.insertString(doc.getLength(), "Intellect: " + s.getIntellect(), null);
            doc.insertString(doc.getLength(), "Level: " + s.getLevel(), null);
            doc.insertString(doc.getLength(), "Max Life: " + s.getMaxLife(), null);
            doc.insertString(doc.getLength(), "Max Mana: " + s.getMaxMana(), null);
            doc.insertString(doc.getLength(), "Movement: " + s.getMovement(), null);
            doc.insertString(doc.getLength(), "Observatin: " + s.getObservation(), null);
            doc.insertString(doc.getLength(), "Offense: " + s.getOffense(), null);
            doc.insertString(doc.getLength(), "Strength: " + s.getStrength(), null);
            doc.insertString(doc.getLength(), "Weapon Modifier: " + s.getWeaponModifier(), null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void generateView() {
        //TODO
    }

    @Override
    public void update(ModelViewBundle mvb) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        stats_jScrollPane_ = new javax.swing.JScrollPane();
        stats_jTextPane_ = new javax.swing.JTextPane();

        stats_jScrollPane_.setViewportView(stats_jTextPane_);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stats_jScrollPane_, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stats_jScrollPane_, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane stats_jScrollPane_;
    private javax.swing.JTextPane stats_jTextPane_;
    // End of variables declaration//GEN-END:variables

    @Override
    public void visit(Stats stats) {
        Application.print("Regular " + stats.toString());
    }

    @Override
    public void visit(SneakStats stats) {
        Application.print("Sneak " + stats.toString());
    }

    @Override
    public void visit(SummonerStats stats) {
        Application.print("Summoner " + stats.toString());
    }

    @Override
    public void visit(SmasherStats stats) {
        Application.print("Smasher " + stats.toString());
    }

}
