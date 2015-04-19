package mvc_bridgeway.command.model_command;

import model.entity.avatar.Avatar;

public class SetSummonerOccupationCommand extends SetOccupationCommand {
    /**
     * CONSTRUCTORS
     */

    public SetSummonerOccupationCommand(Avatar avatar) {
        super(avatar);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void execute() {
        getModel().setSummonerOccupation(getAvatar());
    }
}
