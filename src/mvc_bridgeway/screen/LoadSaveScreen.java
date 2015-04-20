package mvc_bridgeway.screen;

// @author comcc_000

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import model.UserSettings;
import mvc_bridgeway.command.model_command.LaunchScreenCommand;
import mvc_bridgeway.control.physical_control.KeyboardControl;
import mvc_bridgeway.control_map.ControlMap;
import view.viewport.Viewport;
import view.viewport.load_save_viewport.LoadSaveViewport;


public class LoadSaveScreen extends Screen {

    /*Properties*/
    
    public static final LoadMode LOAD = new LoadMode();
    public static final SaveMode SAVE = new SaveMode();
    private Mode currentMode;

    /*Constructors*/
    
    public LoadSaveScreen(Mode mode) {
        super();
        currentMode = mode;
    }

    /*Methods*/
    
    @Override
    protected Viewport createView() {
        return currentMode.createView();
    }

    @Override
    protected ArrayList<ControlMap> getUserControls(UserSettings userSettings) {
        return null;
    }

    @Override
    protected ArrayList<ControlMap> generateDefaultPhysicalControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        return controlMaps;
    }

    @Override
    protected void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*Get-Sets*/

    /*Inner-classes*/
    
    private abstract class Mode {
        public abstract Viewport createView();
    }
    
    public static class SaveMode extends Mode {
        
        public SaveMode() {
            
        }
        
        @Override
        public Viewport createView() {
            return new LoadSaveViewport(LoadSaveViewport.SAVE);
        }
    }
    
    public static class LoadMode extends Mode {
        
        public LoadMode() {
            
        }
        
        @Override
        public Viewport createView() {
            return new LoadSaveViewport(LoadSaveViewport.LOAD);
        }
    }

    /*Test Main Method*/

}
