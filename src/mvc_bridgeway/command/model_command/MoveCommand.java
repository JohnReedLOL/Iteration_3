package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.Entity;
import model.map.direction.Direction;


public class MoveCommand extends ModelCommand {

    /*Properties*/

    private Entity entity;
    private Direction direction;
    
    /*Constructors*/

    public MoveCommand(Entity entity, Direction direction) {
        this.entity = entity;
        this.direction = direction;
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        getModel().move(entity, direction);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
