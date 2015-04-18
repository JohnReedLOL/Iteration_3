package mvc_bridgeway.command.macro_command;

// @author comcc_000

import java.util.ArrayList;
import mvc_bridgeway.command.Command;


public class MacroCommand extends Command {

    /*Properties*/
    
    private ArrayList<Command> commands;

    /*Constructors*/

    public MacroCommand(Command command, Command... cmds) {
        commands = initCommands(command, cmds);
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public final void forward() {
        for (Command command : commands) {
            command.forward();
        }
    }
    
    private ArrayList<Command> initCommands(Command command, Command[] cmds) {
        ArrayList<Command> temp = new ArrayList<Command>();
        temp.add(command);
        for (int i=0; i<cmds.length; i++) {
            temp.add(cmds[i]);
        }
        return temp;
    }
    
    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
