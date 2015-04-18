package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.Entity;
import mvc_bridgeway.screen.Screen;


public class StartNewSneakGameCommand extends ModelCommand {

    

    /*Properties*/
    
    private Screen screen;
    private Entity e;

    /*Constructors*/
    
    public StartNewSneakGameCommand(Screen screen) {
        this.screen = screen;
    }

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().launchScreen(screen);
    }
    
    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
