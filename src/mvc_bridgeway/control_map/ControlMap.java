package mvc_bridgeway.control_map;

// @author comcc_000

import mvc_bridgeway.command.Command;
import mvc_bridgeway.control.Control;


public class ControlMap<Ctrl extends Control, Cmd extends Command> {

    /*Properties*/
    
    private Ctrl control;
    private Cmd command;

    /*Constructors*/
    
    public ControlMap(Ctrl control, Cmd command) {
        this.control = control;
        this.command = command;
    }

    /*Methods*/

    /*Get-Sets*/
    
    public Ctrl getControl() {
        return control;
    }

    public void setControl(Ctrl control) {
        this.control = control;
    }

    public Cmd getCommand() {
        return command;
    }

    public void setCommand(Cmd command) {
        this.command = command;
    }

    /*Inner-classes*/

    /*Test Main Method*/

}
