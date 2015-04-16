package mvc_bridgeway.screen;

// @author comcc_000

import controller.physicalController.PhysicalController;
import controller.virtual_controller.SwingController;
import controller.virtual_controller.VirtualController;
import java.util.ArrayList;
import model.Model;
import model.ModelViewBundle;
import model.UserSettings;
import mvc_bridgeway.control_map.ControlMap;
import view.viewport.Viewport;


public abstract class Screen {

    /*Properties*/
    
    private Model mode;
    private Viewport viewport;
    private PhysicalController physicalController;
    private VirtualController virtualController;

    /*Constructors*/
    
    public Screen() {
        //
    }

    /*Methods*/
    
    protected abstract Viewport createView();
    protected abstract PhysicalController createPhysicalController(Model model, PhysicalController physicalController, UserSettings userSettings);
    protected abstract ArrayList<ControlMap> getUserControls(UserSettings userSettings);
    protected abstract ArrayList<ControlMap> generateDefaultPhysicalControlMaps();
    protected abstract void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls);
       
    protected VirtualController createVirtualController(Model model, ArrayList<ControlMap> virtualControlMaps) {
        return new SwingController(model, virtualControlMaps);
    }
    
    public void updateView(ModelViewBundle mvb) {
        viewport.update(mvb);
    }
    
    public final void init(Model model, PhysicalController physicalController, UserSettings userSettings) {
        viewport = createView();
        initControllers(model, viewport, physicalController, userSettings);
    }
    
    

    protected final void initControllers(Model model, Viewport vp, PhysicalController physicalController, UserSettings userSettings) {
        ArrayList<ControlMap> viewCMs = viewport.getControlMaps();
        //	Controller_Model_Interface cmi = (Controller_Model_Interface)model; //for inital setup
        Model cmi = model;

        virtualController = createVirtualController(cmi, viewCMs);
        initPhysicalController(cmi, physicalController, userSettings);
    }

    protected final void initPhysicalController(Model cmi, PhysicalController physicalController, UserSettings userSettings) {
        ArrayList<ControlMap> userControls = getUserControls(userSettings);
        if (userControls != null) {
            physicalController.configure(userControls);
        } else {
            ArrayList<ControlMap> defaultControls = generateDefaultPhysicalControlMaps();
            physicalController.configure(defaultControls);
            setUserControls(userSettings, defaultControls); //make sure controls are persisted for rebinding
        }
    }

    /*Get-Sets*/
    
    public Viewport getViewport() {
        return viewport;
    }
    
    protected PhysicalController getPhysicalController() {
        return physicalController;
    }

    protected void setPhysicalController(PhysicalController physicalController) {
        this.physicalController = physicalController;
    }

    protected VirtualController getVirtualController() {
        return virtualController;
    }

    protected void setVirtualController(VirtualController virtualController) {
        this.virtualController = virtualController;
    }

    /*Inner-classes*/

    /*Test Main Method*/

}
