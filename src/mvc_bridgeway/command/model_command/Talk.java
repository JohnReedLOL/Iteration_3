package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.Entity;
import model.entity.avatar.Avatar;


public class Talk extends ModelCommand {

    /*Properties*/
    
    private Avatar avatar;
    private Entity entity;

    /*Constructors*/

    public Talk(Avatar avatar, Entity entity) {
        this.avatar = avatar;
        this.entity = entity;
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        getModel().talk(avatar, entity);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
