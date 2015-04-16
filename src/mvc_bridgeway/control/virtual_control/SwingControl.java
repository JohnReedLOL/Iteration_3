package mvc_bridgeway.control.virtual_control;

// @author comcc_000

import javax.swing.JComponent;
import mvc_bridgeway.control.Control;


public class SwingControl extends VirtualControl {

    /*Properties*/
    
    private JComponent jComponent; //for now...

    /*Constructors*/
    
    public SwingControl(JComponent jComponent) {
        this.jComponent = jComponent;
    }

    /*Methods*/

    /*Get-Sets*/
    
    public JComponent getJComponent() {
        return jComponent;
    }

    /*Inner-classes*/

    /*Test Main Method*/

    

}
