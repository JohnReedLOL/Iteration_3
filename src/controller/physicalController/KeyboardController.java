package controller.physicalController;

// @author comcc_000

import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import model.Model;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.control.physical_control.KeyboardControl;
import mvc_bridgeway.control_map.ControlMap;
// @author comcc_000

public class KeyboardController extends PhysicalController<KeyboardControl> {

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
//        int keyCode = ((KeyboardControl) control).getKeyCode();
//        OptionsVirtualController ovc = ((OptionsVirtualController) virtualController);
//        RebindInfo ri = ovc.getRebindInfo();
//        reassignControlWithIntent(new KeyboardControl(keyCode), ri.object, ri.intent);
//        //label key appropriately
//        JButton button = (JButton) ri.component;
//        button.setText(KeyEvent.getKeyText(keyCode));
//        setMode(PhysicalControllerMode.DISABLED); //rebindMode = false; //remember to do this /*Derpy face*/
//        JButton backButton = (JButton) ri.backButton;
//        backButton.setEnabled(true); //re-enable back button 
    }

    private Command getCommand(int keyCode) {
        ArrayList<ControlMap> controlMaps = getControlMaps();
        if (controlMaps == null) {
            return null;
        }
        KeyboardControl control = new KeyboardControl(keyCode);
        ControlMap cm = null;
        KeyboardControl kc = null;
        for (int i = 0; i < controlMaps.size(); i++) {
            cm = controlMaps.get(i);
            kc = (KeyboardControl) cm.getControl();
            if (control.equals(control)) {
                return cm.getCommand();
            }
        }
        return null;
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
                Command command = getCommand(keyCode);
                onControlActivation(command);
            }
            return true;
        }

        
    }

    /*Test Main Method*/

    

}
