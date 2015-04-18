package mvc_bridgeway.command.macro_command;

// @author comcc_000

import java.util.ArrayList;
import mvc_bridgeway.command.Command;


public class MacroCommand<Cmd extends Command> extends Command {

    /*Properties*/
    
    private ArrayList<Cmd> commands;

    /*Constructors*/

    public MacroCommand(Cmd command, Cmd... cmds) {
        commands = initCommands(command, cmds);
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        for (Cmd command : commands) {
            command.execute();
        }
    }

    @Override
    public final void forward() {
        for (Cmd command : commands) {
            command.forward();
        }
    }
    
    private ArrayList<Cmd> initCommands(Cmd command, Cmd[] cmds) {
        ArrayList<Cmd> temp = new ArrayList<>();
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
