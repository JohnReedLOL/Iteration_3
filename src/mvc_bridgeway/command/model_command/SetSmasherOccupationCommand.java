package mvc_bridgeway.command.model_command;

import model.entity.avatar.Avatar;
import model.factories.OccupationFactory;
import model.map.GameWorld;

public class SetSmasherOccupationCommand extends SetOccupationCommand {
    /**
     * CONSTRUCTORS
     */

    public SetSmasherOccupationCommand() {
    	super();
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void execute() {
    	Avatar a = OccupationFactory.generateAvatarSmasherOccupation();
        GameWorld.getCurrentMap().setAvatar(a);
    }
}
