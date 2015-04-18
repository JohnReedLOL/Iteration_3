package mvc_bridgeway.command.model_command;

// @author comcc_000

import mvc_bridgeway.screen.Screen;


public class LaunchScreenCommand extends ModelCommand {

    

    /*Properties*/
    
    private Screen screen;

    /*Constructors*/
    
    public LaunchScreenCommand(Screen screen) {
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
