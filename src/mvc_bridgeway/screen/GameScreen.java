package mvc_bridgeway.screen;

// @author comcc_000

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import model.UserSettings;
import mvc_bridgeway.command.model_command.LaunchScreenCommand;
import mvc_bridgeway.control.physical_control.KeyboardControl;
import mvc_bridgeway.control_map.ControlMap;
import view.viewport.Viewport;
import view.viewport.screen_viewport.GameScreenViewport;


public class GameScreen extends Screen {

    /*Properties*/

    /*Constructors*/
    
    public GameScreen() {
        super();
    }

    /*Methods*/
    
    @Override
    protected Viewport createView() {
        return new GameScreenViewport();
    }

    @Override
    protected ArrayList<ControlMap> getUserControls(UserSettings userSettings) {
        return null;
    }

    @Override
    protected ArrayList<ControlMap> generateDefaultPhysicalControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        controlMaps.add(new ControlMap(new KeyboardControl(KeyEvent.VK_O), new LaunchScreenCommand(new OptionsScreen())));
        return controlMaps;
    }

    @Override
    protected void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls) {
        // TODO: throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
