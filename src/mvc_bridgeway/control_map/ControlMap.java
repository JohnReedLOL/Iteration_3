package mvc_bridgeway.control_map;

// @author comcc_000

import java.util.ArrayList;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.command.macro_command.MacroCommand;
import mvc_bridgeway.control.Control;


public class ControlMap<Ctrl extends Control> {

    /*Properties*/
    
    private Ctrl control;
    private MacroCommand command;

    /*Constructors*/
    
    public ControlMap(Ctrl control, Command command, Command... cmds) { 
        //Cmd is vararg
        this.control = control;
        this.command = initMacroCommand(command, cmds);
    }

    /*Methods*/
    
    public boolean hasControl(Ctrl control) {
        return this.control.equals(control);
    }
    
    private MacroCommand initMacroCommand(Command command, Command... cmds) {
        return new MacroCommand(command, cmds);
    }
    
    @Override
    public boolean equals(Object object) {
        ControlMap cm = (ControlMap)object;
        boolean sameControl = this.control.equals(cm.getControl());
        boolean sameCommand = this.command.equals(cm.getCommand());
        return sameControl && sameCommand;
    }

    /*Get-Sets*/
    
    public Ctrl getControl() {
        return control;
    }

    public void setControl(Ctrl control) {
        this.control = control;
    }

    public MacroCommand getCommand() {
        return command;
    }

    public void setCommand(MacroCommand command) {
        this.command = command;
    }

    /*Inner-classes*/

    /*Test Main Method*/

}
