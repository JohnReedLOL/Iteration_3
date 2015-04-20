package mvc_bridgeway.command.model_command;

// @author comcc_000

import view.viewport.load_save_viewport.LoadSaveViewport;


public class LoadCommand extends ModelCommand {

    /*Properties*/
    
    private LoadSaveViewport viewport;

    /*Constructors*/

    public LoadCommand(LoadSaveViewport viewport) {
        this.viewport = viewport;
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        getModel().load(viewport.getFile());
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
