package mvc_bridgeway.command.model_command;

// @author comcc_000

import application.Application;


public class PauseCommand extends ModelCommand {

    /*Properties*/

    /*Constructors*/
    
    public PauseCommand() {
        
    }

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().setMode(getModel().PAUSE);
        Application.print("Pause");
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
