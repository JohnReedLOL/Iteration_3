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
import mvc_bridgeway.control.virtual_control.swing_control.SwingControl;
import mvc_bridgeway.control.virtual_control.VirtualControl;
import mvc_bridgeway.control_map.ControlMap;
import utility.CollectionUtil;


public abstract class VirtualController<CtrlM extends ControlMap<VirtualControl, Command>> extends Controller {

    /*Properties*/
    protected ArrayList<CtrlM> cms; 

    /*Constructors*/
    public VirtualController(Model model, ArrayList<CtrlM> paramCms) {
        super(model);
        this.cms = paramCms;
        init(CollectionUtil.castToSuper(cms));
    }

    /*Methods*/
    
}
