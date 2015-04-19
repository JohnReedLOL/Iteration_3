package controller.physicalController;

// @author comcc_000

import controller.Controller;
import java.util.ArrayList;
import model.Model;
import model.UserSettings;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.control.Control;
import mvc_bridgeway.control.physical_control.KeyboardControl;
import mvc_bridgeway.control.physical_control.PhysicalControl;
import mvc_bridgeway.control_map.ControlMap;


public abstract class PhysicalController<PCtrl extends PhysicalControl, CtrlMp extends ControlMap<PCtrl>> extends Controller<CtrlMp> {

    /*Properties*/
    
    public final EnabledMode Enabled = new EnabledMode();
    public final DisabledMode Disabled = new DisabledMode();
    public final RebindMode Rebind = new RebindMode();
    //
    private Mode mode = Enabled;

    /*Constructors*/
    
    public PhysicalController(Model model) {
        super(model);
    }
    
    /*Methods*/
    
    public final void setMode(Mode mode) {
        this.mode = mode;
    }
    
    public final void configure(ArrayList<CtrlMp> userControls) {
        init(userControls);
    }
    
    public final void setupForRebind(ControlMap controlMap) {
        setMode(Rebind);
        nullifyControl(controlMap.getControl());
//        setRebindControlMap(controlMap);
//        return controlMap.getControl(); //old Control
    }

    public final void rebind(PCtrl control) {
//        clearMapping(control); //wipe any commands currently mapped to this control
        ControlMap<PhysicalControl> rebindControlMap = UserSettings.getRebindMap();
        Control oldControl = rebindControlMap.getControl();
        rebindControlMap.setControl(control); //the actual rebinding part
        UserSettings.setRebindMap(rebindControlMap);
        setMode(Enabled); //will be Disabled after testing
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
        mode.actionPerformed(control);
    }
    
    protected final void clearMapping(PCtrl control) {
        ArrayList<ControlMap> controlMaps = UserSettings.getRebindSet();
        ControlMap cm;
        for (int i=0; i<controlMaps.size(); i++) {
            cm = controlMaps.get(i);
            if (cm.hasControl(control)) {
                controlMaps.remove(cm);
                i--; //compensate for changing list size
            }
        }
    }
    
    protected final void nullifyControl(Control control) {
        ArrayList<ControlMap> controlMaps = UserSettings.getRebindSet();
        ControlMap cm;
        for (int i=0; i<controlMaps.size(); i++) {
            cm = controlMaps.get(i);
            if (cm.hasControl(control)) {
                cm.setControl(null);
            }
        }
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
            Command command = getCommand(control);
            queueCommandForExecution(command);
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
