package mvc_bridgeway.command.model_command;

import model.entity.avatar.Avatar;

public class DismountCommand extends ModelCommand {
    /**
     * PROPERTIES
     */

    private Avatar avatar;

    /**
     * CONSTRUCTOR
     */

    public DismountCommand(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void execute() {
        getModel().dismount(avatar);
    }
}
