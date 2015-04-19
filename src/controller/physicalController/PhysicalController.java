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
    //
    private CtrlMp rebindControlMap = null;

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
    
    public final PhysicalControl setupForRebind(CtrlMp controlMap) {
        setMode(Rebind);
        setRebindControlMap(controlMap);
        return controlMap.getControl(); //old Control
    }

    public final PCtrl rebind(PCtrl control) {
        clearMapping(control); //wipe any commands currently mapped to this control
        CtrlMp rebindControlMap = getRebindControlMap();
        PCtrl oldControl = rebindControlMap.getControl();
        rebindControlMap.setControl(control); //the actual rebinding part
        UserSettings.setRebindMap(rebindControlMap);
        setMode(Disabled); //will be Disabled after testing
        return oldControl;
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
        ArrayList<CtrlMp> controlMaps = getControlMaps();
        CtrlMp cm;
        for (int i=0; i<controlMaps.size(); i++) {
            cm = controlMaps.get(i);
            if (cm.hasControl(control)) {
                controlMaps.remove(cm);
                i--; //compensate for changing list size
            }
        }
    }
    
    protected final void nullifyControl(PCtrl control) {
        ArrayList<CtrlMp> controlMaps = getControlMaps();
        CtrlMp cm;
        for (int i=0; i<controlMaps.size(); i++) {
            cm = controlMaps.get(i);
            if (cm.hasControl(control)) {
                cm.setControl(null);
            }
        }
    }
    
    /*Get-Sets*/
    
    private final void setRebindControlMap(CtrlMp controlMap) {
        this.rebindControlMap = controlMap;
        nullifyControl(controlMap.getControl());
    }
    
    protected final CtrlMp getRebindControlMap() {
        return rebindControlMap;
    }

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
