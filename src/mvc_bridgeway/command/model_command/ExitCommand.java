package mvc_bridgeway.command.model_command;

// @author comcc_000

public class ExitCommand extends ModelCommand {

    /*Properties*/

    /*Constructors*/

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().exit();
    }
    
    @Override
    public String getDisplayString() {
        return "Exit";
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
