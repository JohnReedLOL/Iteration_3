package mvc_bridgeway.command.model_command;

import model.entity.avatar.Avatar;
import model.map.GameWorld;

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
        GameWorld.getCurrentMap().setAvatar(getAvatar());
    }
}
