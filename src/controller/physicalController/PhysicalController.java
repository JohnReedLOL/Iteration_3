package controller.physicalController;

// @author comcc_000

import controller.Controller;
import java.util.ArrayList;
import model.Model;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.control.Control;
import mvc_bridgeway.control.physical_control.KeyboardControl;
import mvc_bridgeway.control.physical_control.PhysicalControl;
import mvc_bridgeway.control_map.ControlMap;


public abstract class PhysicalController<PCtrl extends PhysicalControl, CtrlMp extends ControlMap<PCtrl, Command>> extends Controller<CtrlMp> {

    /*Properties*/
    
    public final EnabledMode Enabled = new EnabledMode();
    public final DisabledMode Disabled = new DisabledMode();
    public final RebindMode Rebind = new RebindMode();
    //
    protected Mode mode = Disabled;

    /*Constructors*/
    
    public PhysicalController(Model model) {
        super(model);
    }
    
    /*Methods*/
    
    public abstract void rebind(PCtrl physicalControl);
    
    public final void setMode(Mode mode) {
        this.mode = mode;
    }
    
    public final void configure(ArrayList<CtrlMp> userControls) {
        init(userControls);
    }
    
    protected final Command getCommand(PCtrl control) {
        ArrayList<CtrlMp> controlMaps = getControlMaps();
        if (controlMaps == null) {
            return null;
        }
        ControlMap cm = null;
        Control c = null;
        for (int i = 0; i < controlMaps.size(); i++) {
            cm = controlMaps.get(i);
            c = cm.getControl();
            if (control.equals(c)) {
                return cm.getCommand();
            }
        }
        return null;
    }
    
    protected final void activateCommand(PCtrl control) {
        Command command = getCommand(control);
        onControlActivation(command);
    }
    
    /*Get-Sets*/

    /*Inner-classes*/
    
    /*Inner Classes*//////////////////////////////////////////////////////////////////////////////
    private abstract class Mode {
        
        public abstract void actionPerformed(PCtrl control);

    }

    private class EnabledMode extends Mode {

        public EnabledMode() {
            //
        }
        
        @Override
        public void actionPerformed(PCtrl control) {
            activateCommand(control);
        }

    }

    private class DisabledMode extends Mode {

        public DisabledMode() {
            //
        }
        
        @Override
        public void actionPerformed(PCtrl control) {
            //do nothing
        }

    }
    
    private class RebindMode extends Mode {
        
        public RebindMode() {
            //
        }
        
        @Override
        public void actionPerformed(PCtrl control) {
            rebind(control);
        }
        
    }
    /*END Inner Classes*//////////////////////////////////////////////////////////////////////////////

    /*Test Main Method*/

}
