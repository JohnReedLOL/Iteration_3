package mvc_bridgeway.control;

// @author comcc_000

import javax.swing.JComponent;


public class SwingControl extends Control {

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
