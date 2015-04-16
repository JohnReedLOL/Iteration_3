package controller.physicalController;

// @author comcc_000

import controller.Controller;
import java.util.ArrayList;
import model.Model;
import mvc_bridgeway.control.Control;
import mvc_bridgeway.control_map.ControlMap;


public class PhysicalController extends Controller {

    /*Properties*/
    
    protected PhysicalControllerMode mode = new DisabledMode();

    /*Constructors*/
    
    public PhysicalController(Model model) {
        super(model);
    }
    
    /*Methods*/
    
    public void configure(ArrayList<ControlMap> userControls) {
        //TODO
    }

    @Override
    protected void setupCommandToExecuteOnControlActivation(ControlMap controlMap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*Get-Sets*/

    /*Inner-classes*/
    
    /*Inner Classes*//////////////////////////////////////////////////////////////////////////////
    public abstract class PhysicalControllerMode {
        
        /*Properties*/
        
        public static final String ENABLED = "ENABLED";
        public static final String DISABLED = "DISABLED";
        public static final String REBIND = "REBIND";
        
        /*Constructors*/
        
        /*Methods*/

        //Perform tasks on different timings
        public abstract void actionPerformed(Control control);

    }

    private class EnabledMode extends PhysicalControllerMode {

        public EnabledMode() {
            //
        }
        
        @Override
        public void actionPerformed(Control control) {
//            onControlActivated();
        }

    }

    private class DisabledMode extends PhysicalControllerMode {

        public DisabledMode() {
            //
        }
        
        @Override
        public void actionPerformed(Control control) {
            //do nothing
        }

    }
    
    private class RebindMode extends PhysicalControllerMode {
        
        public RebindMode() {
            //
        }
        
        @Override
        public void actionPerformed(Control control) {
//            rebind(control);
        }
        
    }
    /*END Inner Classes*//////////////////////////////////////////////////////////////////////////////

    /*Test Main Method*/

}
