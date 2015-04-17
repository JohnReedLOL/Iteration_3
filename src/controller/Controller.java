package controller;

// @author comcc_000

import java.util.ArrayList;
import model.Model;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.control_map.ControlMap;


public abstract class Controller<CtrlMp extends ControlMap> {

    /*Properties*/
    
    private Model model; //will be interface soon
    //
    private ArrayList<CtrlMp> controlMaps;

    /*Constructors*/
    
    public Controller(Model model) {
        this.model = model;
    }

    /*Methods*/
    
    protected abstract void setupCommandToExecuteOnControlActivation(CtrlMp controlMap);
    
    protected final void onControlActivation(Command command) {
        if (command != null) {
            command.execute(); //soon will be forwarded
        }
    }
    
    protected Model getModel() {
        return model;
    }
    
    protected final void init(ArrayList<CtrlMp> cms) {
        this.controlMaps = cms;
        for (int i=0; cms!= null && i<controlMaps.size(); i++) {
            setupCommandToExecuteOnControlActivation(controlMaps.get(i));
        }
    }

    /*Get-Sets*/
    
    protected ArrayList<CtrlMp> getControlMaps() {
        return controlMaps;
    }

    protected void setControlMaps(ArrayList<CtrlMp> controlMaps) {
        this.controlMaps = controlMaps;
    }

    /*Inner-classes*/

    /*Test Main Method*/

    

}
