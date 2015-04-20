package model;

// @author comcc_000

import java.util.ArrayList;
import mvc_bridgeway.control.physical_control.PhysicalControl;
import mvc_bridgeway.control_map.ControlMap;


public class UserSettings {

    /*Properties*/
    
    private static ArrayList<ControlMap> gameScreenControls;
    //
    private static ControlMap rebindMap = null;
    private static ArrayList<ControlMap> rebindSet = null;

    /*Constructors*/

    /*Methods*/
    
    public ArrayList<ControlMap> getGameScreenControls() {
        return gameScreenControls;
    }

    public void setGameScreenControls(ArrayList<ControlMap> gameScreenControls) {
        this.gameScreenControls = gameScreenControls;
    }
    
    public void updateForRebind(ControlMap cm) {
        ControlMap controlMap = getControlMap(cm);
        if (controlMap != null) {
            rebindMap = cm;
            rebindSet = gameScreenControls;
        } else {
            throw new RuntimeException("Couldn't find controlMap!");
        }
    }
    
    private static ControlMap getControlMap(ControlMap cm) {
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
//        gameScreenControls.add(rebindMap);
    }
    
    public static int getNumGameScreenControls() {
        return gameScreenControls.size();
    }
    
    public static ArrayList<ControlMap> getRebindSet() {
        return rebindSet;
    }

    public static void setRebindSet(ArrayList<ControlMap> rebindSet) {
        UserSettings.rebindSet = rebindSet;
    }

    /*Inner-classes*/

    /*Test Main Method*/

}
