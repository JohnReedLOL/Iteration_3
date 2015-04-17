package mvc_bridgeway.screen;

// @author comcc_000

import controller.physicalController.PhysicalController;
import controller.virtual_controller.VirtualController;
import java.util.ArrayList;
import model.Model;
import model.UserSettings;
import mvc_bridgeway.control_map.ControlMap;
import view.viewport.OptionsViewport;
import view.viewport.Viewport;


public class OptionsScreen extends Screen {

    /*Properties*/

    /*Constructors*/
    
    public OptionsScreen() {
        super();
    }

    /*Methods*/
    
    @Override
    protected Viewport createView() {
        return new OptionsViewport();
    }

    @Override
    protected ArrayList<ControlMap> getUserControls(UserSettings userSettings) {
        return null;
    }

    @Override
    protected ArrayList<ControlMap> generateDefaultPhysicalControlMaps() {
        return new ArrayList<ControlMap>();
    }

    @Override
    protected void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls) {
        //TODO: throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
