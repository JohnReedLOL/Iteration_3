package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.avatar.Avatar;
import model.item.sackbound.SackboundItem;


public class Drop extends ModelCommand {

    /*Properties*/
    
    private Avatar avatar;
    private SackboundItem item;

    /*Constructors*/

    public Drop(Avatar avatar) {
        this.avatar = avatar;
        this.item = item;
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        getModel().drop(avatar);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
