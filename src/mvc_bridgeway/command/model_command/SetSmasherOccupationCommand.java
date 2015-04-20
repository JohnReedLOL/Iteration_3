package mvc_bridgeway.command.model_command;

import model.entity.avatar.Avatar;
import model.map.GameWorld;

public class SetSmasherOccupationCommand extends SetOccupationCommand {
    /**
     * CONSTRUCTORS
     */

    public SetSmasherOccupationCommand(Avatar avatar) {
        super(avatar);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void execute() {
        getModel().setSmasherOccupation(getAvatar());
        GameWorld.getCurrentMap().setAvatar(getAvatar());
    }
}
