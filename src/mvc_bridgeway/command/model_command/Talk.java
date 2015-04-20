package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.Entity;
import model.entity.avatar.Avatar;


public class Talk extends ModelCommand {

    /*Properties*/
    
//    private Avatar avatar;
//    private Entity entity;

    /*Constructors*/

    public Talk() {
//        this.avatar = avatar;
//        this.entity = entity;
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        getModel().talk();
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
