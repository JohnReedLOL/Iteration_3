package mvc_bridgeway.command.model_command;

import model.entity.avatar.Avatar;
import model.factories.OccupationFactory;
import model.map.GameWorld;

public class SetSneakOccupationCommand extends SetOccupationCommand {
    /**
     * CONSTRUCTORS
     */

    public SetSneakOccupationCommand() {
        super();
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void execute() {
    	Avatar a = OccupationFactory.generateAvatarSneakOccupation();
        GameWorld.getCurrentMap().setAvatar(a);
    }
}
