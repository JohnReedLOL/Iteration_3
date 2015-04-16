package controller.virtual_controller;

// @author comcc_000

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import model.Model;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.command.model_command.ModelCommand;
import mvc_bridgeway.control.virtual_control.SwingControl;
import mvc_bridgeway.control_map.ControlMap;
// @author comcc_000

public class SwingController extends VirtualController {

    /*Properties*/

    /*Constructors*/
    
    public SwingController(Model model, ArrayList<ControlMap> paramCms) {
        super(model, paramCms);
    }
    
    /*Methods*/
    
    @Override
    protected void setupCommandToExecuteOnControlActivation(ControlMap controlMap) {
        setListenerForCM(controlMap);
    }

    private void setListenerForCM(ControlMap<SwingControl, ModelCommand> cm) {
        JComponent component = cm.getControl().getJComponent();
        final Command command = cm.getCommand();
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onControlActivation(command);
            }
        };
        setActionListener(al, component);
    }
    
    private void setActionListener(ActionListener al, Component component) {
        if (component instanceof AbstractButton) {
            ((AbstractButton)component).addActionListener(al);
        } else if (component instanceof JTextField) {
            ((JTextField)component).addActionListener(al);
        }
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
