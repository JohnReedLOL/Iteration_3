package mvc_bridgeway.command.model_command;

// @author comcc_000

import view.utility.stat.Stat;


public class AllocateLevelupCommand extends ModelCommand {

    /*Properties*/
    
    private Stat stat;

    /*Constructors*/
    
    public AllocateLevelupCommand(Stat stat) {
        this.stat = stat;
    }

    /*Methods*/
    
    @Override
    public void execute() {
        getModel().levelupStat(stat);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
