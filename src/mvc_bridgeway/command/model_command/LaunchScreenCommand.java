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
    
    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof LaunchScreenCommand) ) {
            return false;
        }
        LaunchScreenCommand command = (LaunchScreenCommand)o;
        return this.screen.equals( command.getScreen() );
    }
    
    /*Get-Sets*/

    public Screen getScreen() {
        return screen;
    }
    
    /*Inner-classes*/

    /*Test Main Method*/

}
