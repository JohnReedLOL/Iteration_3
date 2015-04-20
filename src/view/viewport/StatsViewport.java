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
        displayStats(stats);
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
    
    private void displayStats(StatsOwnership statistics) {
        List<Stat> stats = statistics.getViewStats();
        int numNonLevelableStats = 0;
        if (stats != null && stats.size() + numNonLevelableStats != levelableStatRows.size() + unLevelableStatRows.size()) {
            clearStatRows();
            for (Stat stat : stats) {
                levelableStatRows.add(new LevelableStatRow(stat, this));
            }
            unLevelableStatRows.add( new UnLevelableStatRow("Life: " + statistics.getCurrentLife() + " / " + statistics.getMaxLife(), this));
            unLevelableStatRows.add( new UnLevelableStatRow("Mana: " + statistics.getCurrentMana() + " / " + statistics.getMaxMana(), this));
        } else {
            for (LevelableStatRow statRow : levelableStatRows) {
                statRow.update();
            }
        }
        this.validate();
    }
    
    private void clearStatRows() {
        for (LevelableStatRow statRow : levelableStatRows) {
            statRow.remove();
        }
        levelableStatRows = new ArrayList<LevelableStatRow>();
        for (UnLevelableStatRow statRow : unLevelableStatRows) {
            statRow.remove();
        }
        unLevelableStatRows = new ArrayList<UnLevelableStatRow>();
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
        
        public LevelableStatRow(String content, JPanel jsp) {
            textField = new JTextField(content);
            GridLayout gridLayout = new GridLayout(1, 1);
            panel = new JPanel(gridLayout);
            panel.add(textField);
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
