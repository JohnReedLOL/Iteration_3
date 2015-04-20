/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.viewport;

import application.Application;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ModelViewBundle;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.command.model_command.RebindCommand;
import mvc_bridgeway.command.view_command.ClearRebindButtonCommand;
import mvc_bridgeway.control.Control;
import mvc_bridgeway.control.physical_control.PhysicalControl;
import mvc_bridgeway.control.virtual_control.swing_control.ButtonSwingControl;
import mvc_bridgeway.control.virtual_control.swing_control.SwingControl;
import mvc_bridgeway.control_map.ControlMap;
import utility.ImageUtil;

/**
 *
 * @author comcc_000
 */
public class OptionsViewport extends Viewport {

    private ArrayList<ControlMap> cms = new ArrayList<ControlMap>();
    //
    private ArrayList<MapRow> mapRows = new ArrayList<MapRow>();
    
    public OptionsViewport() {
        initComponents();
        generateView();
    }
    
    @Override
    protected void generateView() {
//        ControlMap controlMap = new ControlMap(new KeyboardControl(KeyEvent.VK_X), new ExitCommand());
//        displayPhysicalControlMap(controlMap);
//        this.validate();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = ImageUtil.getImage("./resources/png/campus_map.gif");
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
    }
    
    @Override
    public void update(ModelViewBundle mvb) {
        ArrayList<ControlMap> gameControlMaps = mvb.getUserSettings().getGameScreenControls();
        displayPhysicalControlMaps(gameControlMaps);
    }

    @Override
    public ArrayList<ControlMap> getControlMaps() {
        return cms;
    }
    
    private void displayPhysicalControlMaps(ArrayList<ControlMap> controlMaps) {
        if (controlMaps == null) {
            return;
        }
        //
        int numControlMaps = controlMaps.size();
        if (numControlMaps != mapRows.size()) {
            clearMapRows();
            for (ControlMap<PhysicalControl> controlMap: controlMaps) {
                mapRows.add(new MapRow(jPanel4, this));
            }
        }
        //
        Application.check(controlMaps.size() == mapRows.size(), "ArrayLists not equal!");
        for (int i=0; i<controlMaps.size(); i++) {
            MapRow mapRow = mapRows.get(i);
            ControlMap controlMap = controlMaps.get(i);
            mapRow.update(controlMap);
        }
        this.validate();
    }
    
    private void clearMapRows() {
        for (int i=0; i<mapRows.size(); i++) {
            MapRow mapRow = mapRows.get(i);
            mapRow.remove();
            mapRows.remove(mapRow);
            i--; //compensate for size decrease
        }
        mapRows = new ArrayList<MapRow>();
//        this.removeAll();
    }
    
    private class MapRow {
        
        /*Properties*/
        
        private JLabel label;
        private JButton button;
        private JPanel panel;
        //
        private JPanel masterPanel;
        private OptionsViewport viewport;
        //
        private ControlMap controlMap = null;
        //
        private ControlMap<SwingControl> vcm = null;
        
        /*Constructors*/
        
        public MapRow(JPanel masterPanel, OptionsViewport viewport) {
            this.masterPanel = masterPanel;
            this.viewport = viewport;
            
            init();
        }
        
        public void update(ControlMap controlMap) {
//            boolean sameMap;
//            if (this.controlMap != null ) {
//               sameMap = !this.controlMap.equals(controlMap);
//            }
            //this.controlMap == null || !this.controlMap.equals(controlMap) 
            if ( true ) {
                displayAction(getAction(controlMap));
                displayKey(getKey(controlMap));
                setControl(controlMap);
                this.controlMap = controlMap;
            } else {
                //do nothing
            }
            
        }
        
        private String getAction(ControlMap controlMap) {
            Command command = controlMap.getCommand();
            if (command!= null) {
                return command.getDisplayString();
            }
            return "";
        }
        
        private String getKey(ControlMap controlMap) {
            Control control = controlMap.getControl();
            if (control != null) {
                return control.toString();
            }
            return "";
        }
        
        private void init() {
            initPanel();
            if (label == null) {
                label = new JLabel();
                panel.add(label);
            }
            if (button == null) {
                button = new JButton();
                panel.add(button);
            }
            masterPanel.add(panel);
        }
        
        private void initPanel() {
            GridLayout gridLayout = new GridLayout(2,2);
            panel = new JPanel(gridLayout);
        }
        
        private void displayAction(String action) {
//            if (label == null) {
//                label = new JLabel();
//                masterPanel.add(label);
//            }
            label.setText(action);
        }
        
        private void displayKey(String key) {
//            if (button == null) {
//                button = new JButton();
//                masterPanel.add(button);
//            }
            button.setText(key);
        }
        
        private void setControl(ControlMap controlMap) {
            //remove old control(s)
            ButtonSwingControl bsc = new ButtonSwingControl(button);
            bsc.removeAllActionListeners();
            //set control
            cms.remove(vcm);
            vcm = new ControlMap( bsc, new RebindCommand(controlMap), new ClearRebindButtonCommand(viewport, bsc));
            cms.add(vcm);
            flagRefreshController();
        }
        
        private void remove() {
            if (label != null) {
                panel.remove(label);
            }
            if (button != null) {
                panel.remove(button);
            }
            if (panel != null) {
                masterPanel.remove(panel);
            }
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

        jPanel4 = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridLayout());
        add(jPanel4, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
