package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.avatar.Avatar;
import model.item.Item;


public class Equip extends ModelCommand {

    /*Properties*/
    
    private Avatar avatar;
    private Item item;

    /*Constructors*/
    
    public Equip(Avatar avatar, Item item) {
        this.avatar = avatar;
        this.item = item;
    }

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().equip(avatar, item);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
