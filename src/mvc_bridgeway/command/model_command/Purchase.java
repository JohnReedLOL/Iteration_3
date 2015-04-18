package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.avatar.Avatar;
import model.item.Item;


public class Purchase extends ModelCommand {

    /*Properties*/
    
    private Avatar avatar;
    private Item item;
    private int price;

    /*Constructors*/

    public Purchase(Avatar avatar, Item item, int price) {
        this.avatar = avatar;
        this.item = item;
        this.price = price;
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        getModel().purchase(avatar, item, price);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
