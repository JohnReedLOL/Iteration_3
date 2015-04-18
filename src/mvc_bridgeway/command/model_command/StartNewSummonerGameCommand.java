package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.Entity;
import mvc_bridgeway.screen.Screen;


public class StartNewSummonerGameCommand extends ModelCommand {

    

    /*Properties*/
    
    private Screen screen;
    private Entity e;

    /*Constructors*/
    
    public StartNewSummonerGameCommand(Screen screen) {
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
