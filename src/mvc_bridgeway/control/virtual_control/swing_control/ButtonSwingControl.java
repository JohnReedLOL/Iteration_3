package mvc_bridgeway.control.virtual_control.swing_control;

// @author comcc_000

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import mvc_bridgeway.command.Command;


public class ButtonSwingControl extends SwingControl<JButton> {

    /*Properties*/

    /*Constructors*/
    
    public ButtonSwingControl(JButton component) {
        super(component);
    }
    
    /*Methods*/
    
    @Override
    public void setListener(final Command command) {
        ActionListener al = generateActionListener(command);
        getComponent().addActionListener(al);
    }
    
    public void setText(String content) {
        getComponent().setText(content);
    }
    
    public void removeAllActionListeners() {
        for( ActionListener al : getComponent().getActionListeners() ) {
            getComponent().removeActionListener( al );
        }
    }
    
    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
