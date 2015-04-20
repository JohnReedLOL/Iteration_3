package mvc_bridgeway.screen;

// @author comcc_000
import application.Application;
import controller.physicalController.PhysicalController;
import controller.virtual_controller.SwingController;
import controller.virtual_controller.VirtualController;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingUtilities;
import model.Model;
import model.ModelViewBundle;
import model.UserSettings;
import mvc_bridgeway.control_map.ControlMap;
import view.MainWindow;
import view.viewport.Viewport;

public abstract class Screen {

    /*Properties*/
    private Model model;
    private Viewport viewport;
    private PhysicalController physicalController;
    private VirtualController virtualController;
    //
//    private static final ExecutorService view_thread_ = Executors.newSingleThreadExecutor();
//    private static final String view_thread_name_ = "View";

    static {
        Runnable name_setter = new Runnable() {
            @Override
            public void run() {
                //Thread.currentThread().setName(view_thread_name_);
                Application.print("name set!");
            }
        };
        //view_thread_.execute(name_setter);
    }

    /*Constructors*/
    public Screen() {
        //
    }

    /*Methods*/
    protected abstract Viewport createView();

    protected abstract ArrayList<ControlMap> getUserControls(UserSettings userSettings);

    protected abstract ArrayList<ControlMap> generateDefaultPhysicalControlMaps();

    protected abstract void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls);

//    public static String getViewThreadName() {
//        return view_thread_name_;
//    }

    public final void onFocusLost() {
        if (model != null) {
            model.setMode(model.PAUSE);
        }
    }

    public final void onFocusGained() {
        if (model != null) {
            model.setMode(model.RUN);
        }
    }

    @Override
    public boolean equals(Object object) {
        Class thisClass = this.getClass();
        Class otherClass = object.getClass();
        return thisClass.isAssignableFrom(otherClass);
    }

    protected VirtualController createVirtualController(Model model, ArrayList<ControlMap> virtualControlMaps) {
        return new SwingController(model, virtualControlMaps);
    }

    public void updateView(final ModelViewBundle mvb) {
        Application.check(SwingUtilities.isEventDispatchThread());
        viewport.update(mvb);
        if (viewport.isRefreshControllerNeeded()) {
            initVirtualController(viewport, model);
        }
    }

    public final void init(Model model, PhysicalController physicalController, UserSettings userSettings) {
        viewport = createView();
        initControllers(model, viewport, physicalController, userSettings);
    }

    protected final void initControllers(Model model, Viewport vp, PhysicalController physicalController, UserSettings userSettings) {
        Model cmi = model;
        initVirtualController(vp, cmi);
        initPhysicalController(cmi, physicalController, userSettings);
    }

    private final void initVirtualController(Viewport view, Model cmi) {
        ArrayList<ControlMap> viewCMs = viewport.getControlMaps();
        //	Controller_Model_Interface cmi = (Controller_Model_Interface)model; //for inital setup
        cmi = model;

        virtualController = createVirtualController(cmi, viewCMs);
    }

    private final void initPhysicalController(Model cmi, PhysicalController physicalController, UserSettings userSettings) {
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
    public Viewport getViewport(MainWindow mainWindow) { //only MainWindow should use this
        return viewport;
    }

    /*Inner-classes*/

    /*Test Main Method*/
}
