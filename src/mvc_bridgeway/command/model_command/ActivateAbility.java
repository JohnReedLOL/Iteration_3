package mvc_bridgeway.command.model_command;

// @author comcc_000

import model.entity.ability.Ability;
import model.entity.avatar.Avatar;


public class ActivateAbility extends ModelCommand {

    /*Properties*/
    
    private Avatar avitar;
    private Ability ability;

    /*Constructors*/

    public ActivateAbility(Avatar avitar, Ability ability) {
        this.avitar = avitar;
        this.ability = ability;
    }
    
    /*Methods*/
    
    @Override
    public void execute() {
        getModel().activateAbility(avitar, ability);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
