package mvc_bridgeway.command.model_command;

// @author comcc_000

import mvc_bridgeway.control_map.ControlMap;


public class RebindCommand extends ModelCommand {

    /*Properties*/
    
    private ControlMap controlMap;

    /*Constructors*/
    
    public RebindCommand(ControlMap controlMap) {
        this.controlMap = controlMap;
    }

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().setupPhysicalControllerForRebind(controlMap);
    }
    
    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
