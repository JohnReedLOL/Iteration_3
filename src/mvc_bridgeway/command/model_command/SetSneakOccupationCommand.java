package mvc_bridgeway.command.model_command;

import model.entity.avatar.Avatar;

public class SetSneakOccupationCommand extends SetOccupationCommand {
    /**
     * CONSTRUCTORS
     */

    public SetSneakOccupationCommand(Avatar avatar) {
        super(avatar);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void execute() {
        getModel().setSneakOccupation(getAvatar());
    }
}
