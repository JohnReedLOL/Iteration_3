package mvc_bridgeway.command.model_command;

// @author comcc_000

import mvc_bridgeway.command.Command;


public class SaveCommand extends ModelCommand {

    /*Properties*/

    /*Constructors*/
    
    public SaveCommand() {
        
    }

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().save();
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
