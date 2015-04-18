package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.armory.Armory;
import model.armory.ArmoryOwnership;
import model.entity.Entity;
import model.inventory.Sack;
import mvc_bridgeway.screen.Screen;


public class StartNewSneakGameCommand extends ModelCommand {

    

    /*Properties*/
    
    private Screen screen;
    private Entity e;

    /*Constructors*/
    
    public StartNewSneakGameCommand(Screen screen) {
        this.screen = screen;
        // TODO: making new game stuff
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
