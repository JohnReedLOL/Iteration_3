package mvc_bridgeway.command.model_command;

// @author comcc_000

import application.Application;
import mvc_bridgeway.command.Command;


public class ResumeCommand extends ModelCommand {

    /*Properties*/

    /*Constructors*/
    
    public ResumeCommand() {
        
    }

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().setMode(getModel().RUN);
        Application.print("Run");
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
