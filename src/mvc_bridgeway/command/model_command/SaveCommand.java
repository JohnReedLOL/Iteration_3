package mvc_bridgeway.command.model_command;

// @author comcc_000

import view.viewport.load_save_viewport.LoadSaveViewport;


public class SaveCommand extends ModelCommand {

    /*Properties*/
    
    private LoadSaveViewport viewport;

    /*Constructors*/

    public SaveCommand(LoadSaveViewport viewport) {
        this.viewport = viewport;
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        getModel().save(viewport.getFile());
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
