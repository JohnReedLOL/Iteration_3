package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.avatar.Avatar;
import model.entity.occupation.Occupation;


public class SetOccupationCommand extends ModelCommand {

    /*Properties*/
    
    private Avatar avatar;
    private Occupation occupation;

    /*Constructors*/
    
    public SetOccupationCommand(Avatar avatar, Occupation occupation) {
        this.avatar = avatar;
        this.occupation = occupation;
    }

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().setOccupation(avatar, occupation);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
