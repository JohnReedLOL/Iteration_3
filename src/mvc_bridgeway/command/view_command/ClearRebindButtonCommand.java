package mvc_bridgeway.command.view_command;

// @author comcc_000

import mvc_bridgeway.control.virtual_control.swing_control.ButtonSwingControl;
import view.viewport.Viewport;


public class ClearRebindButtonCommand extends ViewCommand {

    /*Properties*/
    
    private ButtonSwingControl button;

    /*Constructors*/
    
    public ClearRebindButtonCommand(Viewport viewport, ButtonSwingControl button) {
        super(viewport);
        this.button = button;
    }

    /*Methods*/
    
    @Override
    public void execute() {
        button.setText(""); //clear button
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
