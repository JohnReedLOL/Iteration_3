package mvc_bridgeway.screen;

// @author comcc_000

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import model.Model;
import model.UserSettings;
import model.map.direction.NorthDirection;
import model.map.direction.NorthEastDirection;
import model.map.direction.NorthWestDirection;
import model.map.direction.SouthDirection;
import model.map.direction.SouthEastDirection;
import model.map.direction.SouthWestDirection;
import mvc_bridgeway.command.model_command.DismountCommand;
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
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_3), new MoveCommand(new NorthWestDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_4), new MoveCommand(new NorthEastDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_5), new MoveCommand(new SouthWestDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_6), new MoveCommand(new SouthEastDirection())));

        //OTHER THINGS FOR SANE PEOPLE
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_NUMPAD8), new MoveCommand(new NorthDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_NUMPAD2), new MoveCommand(new SouthDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_NUMPAD7), new MoveCommand(new NorthWestDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_NUMPAD9), new MoveCommand(new NorthEastDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_NUMPAD1), new MoveCommand(new SouthWestDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_NUMPAD3), new MoveCommand(new SouthEastDirection())));

        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_W), new MoveCommand(new NorthDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_S), new MoveCommand(new SouthDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_Q), new MoveCommand(new NorthWestDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_E), new MoveCommand(new NorthEastDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_A), new MoveCommand(new SouthWestDirection())));
        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_D), new MoveCommand(new SouthEastDirection())));

        controlMaps.add(new ControlMap( new KeyboardControl(KeyEvent.VK_P), new DismountCommand(Model.getAvatar())));

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
