package mvc_bridgeway.screen;

// @author comcc_000

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import model.UserSettings;
import model.map.direction.NorthDirection;
import model.map.direction.SouthDirection;
import mvc_bridgeway.command.model_command.ExitCommand;
import mvc_bridgeway.command.model_command.LaunchScreenCommand;
import mvc_bridgeway.command.model_command.MoveCommand;
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
        return userSettings.getGameScreenControls();
    }

    @Override
    protected ArrayList<ControlMap> generateDefaultPhysicalControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        controlMaps.add( new ControlMap( new KeyboardControl(KeyEvent.VK_O), new LaunchScreenCommand(new OptionsScreen() ) ) );
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_X),new ExitCommand() ) );
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_1), new MoveCommand(new NorthDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_2), new MoveCommand(new SouthDirection())));
        return controlMaps;
    }

    @Override
    protected void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls) {
        userSettings.setGameScreenControls(defaultControls);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
