package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.Model;
import mvc_bridgeway.command.Command;


public abstract class ModelCommand extends Command {

    /*Properties*/
    
    private static Model model; //will be interface soon

    /*Constructors*/

    /*Methods*/
    
    @Override
    public final void forward() {
        model.queueCommandForExecution(this);
    }

    /*Get-Sets*/
    
    public static void setModel(Model model) {
        ModelCommand.model = model;
    }
    
    protected Model getModel() {
        return model;
    }

    /*Inner-classes*/

    /*Test Main Method*/

    

}
