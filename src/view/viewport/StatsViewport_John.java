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
public class StatsViewport_John extends Viewport implements StatsVisitor, SneakStatsVisitor, SummonerStatsVisitor, SmasherStatsVisitor {


    public StatsViewport_John() {
        initComponents();
        generateView();
    }

    @Override
    public void update(ModelViewBundle mvb) {
        Avatar avatar = mvb.getAvatar();
        renderAllStats(avatar);
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        //TODOD
        return controlMaps;
    }

    @Override
    protected void generateView() {
        stats_jTextPane_.setEditable(false);
    }
    
    

    private void renderAllStats(Avatar a) {
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
            doc.insertString(doc.getLength(), "Start of stats (actual avatar stats from ModelViewBundle):\n", null);

            doc.insertString(doc.getLength(), "Skill points: " + a.getStatsOwnership().getSkillPoints() + "\n", null);
            doc.insertString(doc.getLength(), "Stats points: " + a.getStatsOwnership().getStatPoints() + "\n", null);
            doc.insertString(doc.getLength(), "Booty: " + a.getBooty() + "\n", null);
            renderStats(a.getStatsOwnership().getStats(), doc, keyWord);
            doc.insertString(doc.getLength(), "\nEnd of stats\n", keyWord);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void renderStats(Stats s, StyledDocument doc, SimpleAttributeSet keyWord) {
        try {
            doc.insertString(doc.getLength(), "Affinity: " + s.getAffinity() + "\n", null);
            doc.insertString(doc.getLength(), "Agility: " + s.getAgility() + "\n", null);
            doc.insertString(doc.getLength(), "Armor: " + s.getArmor() + "\n", null);
            doc.insertString(doc.getLength(), "Armor Modifier: " + s.getArmorModifier() + "\n", null);
            doc.insertString(doc.getLength(), "Bargain: " + s.getBargain() + "\n", null);
            doc.insertString(doc.getLength(), "Bind Wounds: " + s.getBindWounds() + "\n", null);
            doc.insertString(doc.getLength(), "CurrentLife: " + s.getCurrentLife() + "\n", null);
            doc.insertString(doc.getLength(), "CurrentMana: " + s.getCurrentMana() + "\n", null);
            doc.insertString(doc.getLength(), "Defense: " + s.getDefense() + "\n", null);
            doc.insertString(doc.getLength(), "Experience: " + s.getExperience() + "\n", null);
            doc.insertString(doc.getLength(), "Intellect: " + s.getIntellect() + "\n", null);
            doc.insertString(doc.getLength(), "Level: " + s.getLevel() + "\n", null);
            doc.insertString(doc.getLength(), "Max Life: " + s.getMaxLife() + "\n", null);
            doc.insertString(doc.getLength(), "Max Mana: " + s.getMaxMana() + "\n", null);
            doc.insertString(doc.getLength(), "Movement: " + s.getMovement() + "\n", null);
            doc.insertString(doc.getLength(), "Observatin: " + s.getObservation() + "\n", null);
            doc.insertString(doc.getLength(), "Offense: " + s.getOffense() + "\n", null);
            doc.insertString(doc.getLength(), "Strength: " + s.getStrength() + "\n", null);
            doc.insertString(doc.getLength(), "Weapon Modifier: " + s.getWeaponModifier() + "\n", null);
        } catch (Exception e) {
            System.out.println(e);
        }
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
