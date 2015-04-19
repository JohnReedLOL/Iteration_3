package model;

// @author comcc_000

import java.util.ArrayList;
import mvc_bridgeway.control.physical_control.PhysicalControl;
import mvc_bridgeway.control_map.ControlMap;


public class UserSettings {

    /*Properties*/
    
    private ArrayList<ControlMap> gameScreenControls;
    //
    private static ControlMap rebindMap = null;

    /*Constructors*/

    /*Methods*/
    
    public ArrayList<ControlMap> getGameScreenControls() {
        return gameScreenControls;
    }

    public void setGameScreenControls(ArrayList<ControlMap> gameScreenControls) {
        this.gameScreenControls = gameScreenControls;
    }
    
    public void updateFromRebind(ControlMap cm) {
        ControlMap controlMap = getControlMap(cm);
        if (controlMap != null) {
            rebindMap = cm;
        } else {
            throw new RuntimeException("Couldn't find controlMap!");
        }
    }
    
    private ControlMap getControlMap(ControlMap cm) {
        for (ControlMap controlMap : gameScreenControls) {
            if (controlMap.equals(cm)) {
                return controlMap;
            }
        }
        return null;
    }

    /*Get-Sets*/
    
    public static ControlMap getRebindMap() {
        return rebindMap;
    }

    public static void setRebindMap(ControlMap rebindMap) {
        UserSettings.rebindMap = rebindMap;
    }

    /*Inner-classes*/

    /*Test Main Method*/

}
