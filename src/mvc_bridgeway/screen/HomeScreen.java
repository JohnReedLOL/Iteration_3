package mvc_bridgeway.screen;

// @author comcc_000

import controller.physicalController.PhysicalController;
import controller.virtual_controller.VirtualController;
import java.util.ArrayList;
import model.Model;
import model.UserSettings;
import mvc_bridgeway.control_map.ControlMap;
import view.viewport.HomeViewport;
import view.viewport.Viewport;


public class HomeScreen extends Screen {

    /*Properties*/

    /*Constructors*/
    
    public HomeScreen() {
        super();
    }

    /*Methods*/
    
    @Override
    protected Viewport createView() {
        return new HomeViewport();
    }

    @Override
    protected VirtualController createVirtualController(Model model, ArrayList<ControlMap> virtualControlMaps) {
        return new VirtualController(model, virtualControlMaps);
    }

    @Override
    protected PhysicalController createPhysicalController(Model model, PhysicalController physicalController, UserSettings userSettings) {
        return physicalController;
    }

    @Override
    protected ArrayList<ControlMap> getUserControls(UserSettings userSettings) {
        return null;
    }

    @Override
    protected ArrayList<ControlMap> generateDefaultPhysicalControlMaps() {
        return null;
    }
    
    @Override
    protected void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls) {
        //TODO
    }
    
    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
