package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.avatar.Avatar;


public abstract class SetOccupationCommand extends ModelCommand {

    /*Properties*/
    
    private Avatar avatar;

    /*Constructors*/
    
    public SetOccupationCommand(Avatar avatar) {
        this.avatar = avatar;
    }

    /*Methods*/
    
//    public void setAvatar(Avatar avatar) {
//        this.avatar = avatar;
//    }

    /*Get-Sets*/

    protected Avatar getAvatar() {
        return this.avatar;
    }

    /*Inner-classes*/

    /*Test Main Method*/

}
