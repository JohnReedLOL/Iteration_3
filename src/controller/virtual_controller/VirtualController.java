package controller.virtual_controller;

// @author comcc_000

import controller.Controller;
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
import mvc_bridgeway.control.SwingControl;
import mvc_bridgeway.control_map.ControlMap;


public class VirtualController extends Controller {

    /*Properties*/
    protected ArrayList<ControlMap> cms; 

    /*Constructors*/
    public VirtualController(Model model, ArrayList<ControlMap> ims) {
        super(model);
        this.cms = ims;
        setListenersForIMs();
    }

    /*Methods*/
    
    private final void setListenersForIMs() {
        int numims = cms.size();
        ControlMap im;
        for (int i=0; i<numims ; i++) {
            im = cms.get(i);
            setListenerForIM(im);
        }
    }

    private void setListenerForIM(ControlMap<SwingControl, ModelCommand> cm) {
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

}
