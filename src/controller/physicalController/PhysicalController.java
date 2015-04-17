package controller.physicalController;

// @author comcc_000

import controller.Controller;
import java.util.ArrayList;
import model.Model;
import mvc_bridgeway.control.Control;
import mvc_bridgeway.control.physical_control.PhysicalControl;
import mvc_bridgeway.control_map.ControlMap;


public abstract class PhysicalController<PCtrl extends PhysicalControl> extends Controller {

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
    
    public void setMode(Mode mode) {
        this.mode = mode;
    }
    
    public void configure(ArrayList<ControlMap> userControls) {
        init(userControls);
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
//            onControlActivated();
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
