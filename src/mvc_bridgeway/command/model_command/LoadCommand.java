package mvc_bridgeway.command.model_command;

// @author comcc_000

import mvc_bridgeway.command.Command;


public class LoadCommand extends ModelCommand {

    /*Properties*/

    /*Constructors*/
    
    public LoadCommand() {
        
    }

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().load();
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
