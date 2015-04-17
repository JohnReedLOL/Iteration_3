package mvc_bridgeway.command.view_command;

// @author comcc_000

import mvc_bridgeway.command.Command;
import view.viewport.Viewport;


public abstract class ViewCommand extends Command {

    /*Properties*/
    
    private Viewport viewport;

    /*Constructors*/
    
    public ViewCommand(Viewport viewport) {
        this.viewport = viewport;
    }

    /*Methods*/
    
    @Override
    public final void forward() {
        Viewport.queueCommandForExecution(this);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
