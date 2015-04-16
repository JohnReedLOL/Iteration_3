package controller;

// @author comcc_000

import model.Model;
import mvc_bridgeway.command.Command;


public class Controller {

    /*Properties*/
    
    private Model model; //will be interface soon

    /*Constructors*/
    
    public Controller(Model model) {
        this.model = model;
    }

    /*Methods*/
    
    protected final void onControlActivation(Command command) {
        command.execute(); //soon will be forwarded
    }
    
    protected Model getModel() {
        return model;
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
