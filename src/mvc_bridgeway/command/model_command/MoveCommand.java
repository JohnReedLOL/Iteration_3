package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.Entity;
import model.map.GameWorld;
import model.map.direction.Direction;


public class MoveCommand extends ModelCommand {

    /*Properties*/

    private Direction direction;

    /*Constructors*/

    public MoveCommand(Direction direction) {
        this.direction = direction;
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        // TODO (maybe?): Have a check to make sure the move was successfull, if not, display a message to the user using a Logging system.
        getModel().move(GameWorld.getAvatar(), direction);
    }

    @Override
    public String getDisplayString() {


        return "Move " + direction.getClass().getSimpleName().toString();
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
