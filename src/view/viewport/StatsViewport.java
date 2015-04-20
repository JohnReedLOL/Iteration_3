/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.ModelViewBundle;
import model.entity.stats.StatsOwnership;
import mvc_bridgeway.command.model_command.AllocateLevelupCommand;
import mvc_bridgeway.control.virtual_control.swing_control.ButtonSwingControl;
import mvc_bridgeway.control_map.ControlMap;
import view.utility.stat.Stat;

public class StatsViewport extends Viewport {

    private ArrayList<ControlMap> cms = new ArrayList<ControlMap>();
    //
    private ArrayList<LevelableStatRow> levelableStatRows = new ArrayList<LevelableStatRow>();
    private ArrayList<UnLevelableStatRow> unLevelableStatRows = new ArrayList<UnLevelableStatRow>();

    public StatsViewport() {
        initComponents();
        generateView();
    }

    @Override
    public void update(ModelViewBundle mvb) {
        StatsOwnership stats = mvb.getAvatar().getStatsOwnership();
        int booty = mvb.getBooty();
        displayStats(stats, booty);
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        return cms;
    }

    @Override
    protected void generateView() {
//        add(new JButton("Stuff"));
//        validate();
    }
    
    private void displayStats(StatsOwnership statistics, int booty) {
        List<Stat> stats = statistics.getViewStats();
        int numNonLevelableStats = 12;
        if (stats != null && stats.size() + numNonLevelableStats != levelableStatRows.size() + unLevelableStatRows.size()) {
            clearStatRows();
            clearCMs();
            for (Stat stat : stats) {
                levelableStatRows.add(new LevelableStatRow(stat, this));
            }
            unLevelableStatRows.add( new UnLevelableStatRow("Life: " + statistics.getCurrentLife() + " / " + statistics.getMaxLife(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("Mana: " + statistics.getCurrentMana() + " / " + statistics.getMaxMana(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("Booty: " + booty, this));
            unLevelableStatRows.add( new UnLevelableStatRow("Level: " + statistics.getLevel(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("SkillPts: " + statistics.getSkillPoints(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("StatPts: " + statistics.getStatPoints(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("Armor: " + statistics.getArmor(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("Affinity: " + statistics.getAffinity(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("ArmorMod: " + statistics.getArmorMod(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("Offense: " + statistics.getOffense(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("Defense: " + statistics.getDefense(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("WeaponMod: " + statistics.getWeaponMod(), this));
            flagRefreshController();
        } else {
            for (LevelableStatRow statRow : levelableStatRows) {
                statRow.update();
            }
            unLevelableStatRows.get(0).update("Life: " + statistics.getCurrentLife() + " / " + statistics.getMaxLife());
            unLevelableStatRows.get(1).update("Mana: " + statistics.getCurrentMana() + " / " + statistics.getMaxMana());
            unLevelableStatRows.get(2).update("Booty: " + booty);
            unLevelableStatRows.get(2).update("Level: " + statistics.getLevel());
            unLevelableStatRows.get(3).update("SkillPts: " + statistics.getSkillPoints());
            unLevelableStatRows.get(4).update("StatPts: " + statistics.getStatPoints());
            unLevelableStatRows.get(5).update("Armor: " + statistics.getArmor());
            unLevelableStatRows.get(6).update("Affinity: " + statistics.getAffinity());
            unLevelableStatRows.get(7).update("ArmorMod: " + statistics.getArmorMod());
            unLevelableStatRows.get(8).update("Offense: " + statistics.getOffense());
            unLevelableStatRows.get(9).update("Defense: " + statistics.getDefense());
            unLevelableStatRows.get(10).update("WeaponMod: " + statistics.getWeaponMod());
        }
        this.validate();
    }
    
    private void clearStatRows() {
        for (LevelableStatRow lsr : levelableStatRows) {
            lsr.remove();
        }
        levelableStatRows = new ArrayList<LevelableStatRow>();
        for (UnLevelableStatRow ulsr : unLevelableStatRows) {
            ulsr.remove();
        }
        unLevelableStatRows = new ArrayList<UnLevelableStatRow>();
    }
    
    private void clearCMs() {
        cms = new ArrayList<ControlMap>();
    }
    
    /*Inner-Classes*/
    
    private abstract class StatRow {
        
        public abstract void remove();
        
    }
    
    private class UnLevelableStatRow extends StatRow {
        private JTextField textField;
        private JPanel panel;
        //
        private JPanel masterPanel;
        
        public UnLevelableStatRow(String content, JPanel jsp) {
            this.masterPanel = jsp;
            textField = new JTextField(content);
            GridLayout gridLayout = new GridLayout(1, 1);
            panel = new JPanel(gridLayout);
            panel.add(textField);
            masterPanel.add(panel);
        }
        
        @Override
        public void remove() {
            masterPanel.remove(panel);
        }
        
        public void update(String content) {
            textField.setText(content);
        }
    }
    
    private class LevelableStatRow extends StatRow {
        
        private Stat stat;
        private JTextField textField;
        private JPanel panel;
        private JButton button;
        //
        private JPanel masterPanel;
        
        public LevelableStatRow(Stat stat, JPanel jsp) {
            this.stat = stat;
            this.masterPanel = jsp;
            textField = initStatField(stat);
            button = initLevelupButton(stat);
            setControl(button);
            initPanel();
            masterPanel.add(panel);
        }
        
        public void update() {
            String display = stat.getName() + ": " + stat.getMag();
            textField.setText(display);
        }
        
        public void remove() {
            masterPanel.remove(panel);
        }
        
        private JTextField initStatField(Stat s) {
            String display = s.getName() + ": " + s.getMag();
            JTextField tf = new JTextField(display);
            return tf;
        }
        
        private JButton initLevelupButton(Stat s) {
            JButton butt = new JButton("+");
            return butt;
        }
        
        private void setControl(JButton butt) {
            cms.add(new ControlMap(new ButtonSwingControl(butt), new AllocateLevelupCommand(stat)));
        }
        
        private void initPanel() {
            GridLayout gridLayout = new GridLayout(1, 2);
            panel = new JPanel(gridLayout);
            panel.add(textField);
            panel.add(button);
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

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
