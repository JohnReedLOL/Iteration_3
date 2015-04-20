package mvc_bridgeway.screen;

// @author comcc_000

import java.util.ArrayList;
import model.UserSettings;
import mvc_bridgeway.control_map.ControlMap;
import view.viewport.TradeViewport;
import view.viewport.Viewport;


public class TradeScreen extends Screen {

    /*Properties*/

    /*Constructors*/
    
    public TradeScreen() {
        super();
    }

    /*Methods*/
    
    @Override
    protected Viewport createView() {
        return new TradeViewport();
    }

    @Override
    protected ArrayList<ControlMap> getUserControls(UserSettings userSettings) {
        return null;
    }

    @Override
    protected ArrayList<ControlMap> generateDefaultPhysicalControlMaps() {
        ArrayList<ControlMap> controlMaps = new ArrayList<ControlMap>();
        return controlMaps;
    }

    @Override
    protected void setUserControls(UserSettings userSettings, ArrayList<ControlMap> defaultControls) {
        //
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
