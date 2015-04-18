package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.Entity;
import mvc_bridgeway.screen.Screen;


public class StartNewSmasherGameCommand extends ModelCommand {

    

    /*Properties*/
    
    private Screen screen;
    private Entity e;

    /*Constructors*/
    
    public StartNewSmasherGameCommand(Screen screen) {
        this.screen = screen;
        // TODO: create a new smasher entity
        // Create the Map
        // place the Game objects on the map
        
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
