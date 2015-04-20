package mvc_bridgeway.command.model_command;

import model.entity.avatar.Avatar;
import model.factories.OccupationFactory;
import model.map.GameWorld;

public class SetSummonerOccupationCommand extends SetOccupationCommand {
    /**
     * CONSTRUCTORS
     */

    public SetSummonerOccupationCommand() {
        super();
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void execute() {
    	Avatar a = OccupationFactory.generateAvatarSummonerOccupation();
        GameWorld.getCurrentMap().setAvatar(a);
    }
}
