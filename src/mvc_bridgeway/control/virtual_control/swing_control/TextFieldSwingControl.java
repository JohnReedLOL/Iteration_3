package mvc_bridgeway.control.virtual_control.swing_control;

// @author comcc_000

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mvc_bridgeway.command.Command;


public class TextFieldSwingControl extends SwingControl<JTextField> {

    /*Properties*/

    /*Constructors*/
    
    public TextFieldSwingControl(JTextField component) {
        super(component);
    }
    
    /*Methods*/
    
    @Override
    public void setListener(final Command command) {
        ActionListener al = generateActionListener(command);
        getComponent().addActionListener(al);
    }
    
    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
