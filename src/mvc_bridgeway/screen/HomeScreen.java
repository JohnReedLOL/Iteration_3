package mvc_bridgeway.screen;

// @author comcc_000

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import model.UserSettings;
import mvc_bridgeway.command.model_command.ExitCommand;
import mvc_bridgeway.command.model_command.LaunchScreenCommand;
import mvc_bridgeway.command.model_command.PauseCommand;
import mvc_bridgeway.command.model_command.RebindCommand;
import mvc_bridgeway.command.model_command.ResumeCommand;
import mvc_bridgeway.control.physical_control.KeyboardControl;
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
    protected ArrayList<ControlMap> getUserControls(UserSettings userSettings) {
        return null;
    }

    /**
     * Generates the screen's initial keyboard mappings
     * @return The mapped keys
     */
    @Override
    protected ArrayList<ControlMap> generateDefaultPhysicalControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        ControlMap exitMap = new ControlMap(new KeyboardControl(KeyEvent.VK_X), new ExitCommand());
        controlMaps.add(exitMap);
        controlMaps.add(new ControlMap(new KeyboardControl(KeyEvent.VK_Y), new RebindCommand(exitMap)));
        controlMaps.add(new ControlMap(new KeyboardControl(KeyEvent.VK_P), new PauseCommand()));
        controlMaps.add(new ControlMap(new KeyboardControl(KeyEvent.VK_R), new ResumeCommand()));
        controlMaps.add(new ControlMap(new KeyboardControl(KeyEvent.VK_O), new LaunchScreenCommand(new OptionsScreen())));
        controlMaps.add(new ControlMap(new KeyboardControl(KeyEvent.VK_L), new LaunchScreenCommand(new LoadSaveScreen(LoadSaveScreen.LOAD))));
        controlMaps.add(new ControlMap(new KeyboardControl(KeyEvent.VK_S), new LaunchScreenCommand(new LoadSaveScreen(LoadSaveScreen.SAVE))));
        return controlMaps;
    }
    
    @Override
    protected void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls) {
        //TODO
    }
    
    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
