package mvc_bridgeway.command;

// @author comcc_000

import mvc_bridgeway.command.macro_command.MacroCommand;


public abstract class Command {

    /*Properties*/

    /*Constructors*/

    /*Methods*/
    
    public abstract void execute();
    public abstract void forward();
    
    public String getDisplayString() {
        String className = this.getClass().getSimpleName().toString();
        return "Display String for " + className + " not implemented yet...";
    }
    
    @Override
    public boolean equals(Object object) {
        Class thisClass = this.getClass();
        Class otherClass = object.getClass();
        return thisClass.isAssignableFrom(otherClass);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
