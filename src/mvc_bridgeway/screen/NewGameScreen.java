package mvc_bridgeway.screen;

// @author comcc_000

import controller.physicalController.PhysicalController;
import controller.virtual_controller.VirtualController;
import java.util.ArrayList;
import model.Model;
import model.UserSettings;
import mvc_bridgeway.control_map.ControlMap;
import view.viewport.NewGameViewport;
import view.viewport.Viewport;


public class NewGameScreen extends Screen {

    /*Properties*/

    /*Constructors*/
    
    public NewGameScreen() {
        super();
    }

    /*Methods*/
    
    @Override
    protected Viewport createView() {
        return new NewGameViewport();
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
        return new ArrayList<ControlMap>();
    }

    @Override
    protected void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls) {
        //TODO
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
