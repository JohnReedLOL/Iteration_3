package controller.physicalController;

import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import model.Model;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.control.Control;
import mvc_bridgeway.control.physical_control.KeyboardControl;
import mvc_bridgeway.control_map.ControlMap;
// @author comcc_000

public class KeyboardController extends PhysicalController<KeyboardControl, ControlMap<KeyboardControl, Command>> {

    /*Properties*/

    private KeyboardFocusManager keyboardManager;

    /*Constructors*/
    
    public KeyboardController(Model model) {
        super(model);
        
        initKeyboardManager();
    }

    /*Methods*/
    
    @Override
    protected void setupCommandToExecuteOnControlActivation(ControlMap controlMap) {
        //do nothing in this case...
    }
    
    private void initKeyboardManager() {
        keyboardManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        keyboardManager.addKeyEventPostProcessor(new EnterKeyListener(getModel()));
    }
    
    @Override
    public void rebind(KeyboardControl control) {
        clearMapping(control); //wipe any commands currently mapped to this control
        ControlMap rebindControlMap = getRebindControlMap();
        rebindControlMap.setControl(control); //the actual rebinding part
        setMode(Disabled); 
    }
    
    /*Get-Sets*/

    /*Inner-classes*/
    
    class EnterKeyListener implements KeyEventPostProcessor {

        private Model model;

        public EnterKeyListener(Model model) {
            this.model = model;
        }

        @Override
        public boolean postProcessKeyEvent(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                KeyboardControl control = new KeyboardControl(keyCode);
                activateCommand(control);
            }
            return true;
        }

        
    }

    /*Test Main Method*/

    

}
