package mvc_bridgeway.control.virtual_control.swing_control;

// @author comcc_000

import application.Application;
import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.control.virtual_control.VirtualControl;


public abstract class SwingControl<Cmpnt extends JComponent> extends VirtualControl {

    /*Properties*/
    
    private Cmpnt component; //for now...

    /*Constructors*/
    
    public SwingControl(Cmpnt component) {
        this.component = component;
    }

    /*Methods*/
    
    public abstract void setListener(Command command);
    
    protected final ActionListener generateActionListener(final Command command) {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.print("actionPerformed");
                Controller.queueCommandForExecution(command);
            }
        };
        return al;
    }

    /*Get-Sets*/
    
    public Cmpnt getComponent() {
        return component;
    }

    /*Inner-classes*/

    /*Test Main Method*/

    

}
