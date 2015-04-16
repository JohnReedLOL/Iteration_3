package view.viewport.screen_viewport;

// @author comcc_000

import java.util.ArrayList;
import model.ModelViewBundle;
import mvc_bridgeway.control_map.ControlMap;
import view.viewport.Viewport;


public abstract class ScreenViewport extends Viewport {

    /*Properties*/
    
    private ArrayList<Viewport> interiorViewports = new ArrayList<>();

    /*Constructors*/

    /*Methods*/
    
    @Override
    protected void addViewport(Viewport viewport) {
        interiorViewports.add(viewport);
        super.addViewport(viewport);
    }
    
    @Override
    public void update(ModelViewBundle mvb) {
        int numInteriorViewports = interiorViewports.size();
        Viewport viewport;
        for (int i=0; i<numInteriorViewports; i++) {
            viewport = interiorViewports.get(i);
            viewport.update(mvb);
        }
    }
    
    @Override
    public ArrayList<ControlMap> getControlMaps() {
        ArrayList<ControlMap> ims = new ArrayList<ControlMap>(1);
        ArrayList<ControlMap> temp_ims = new ArrayList<ControlMap>(1);
        int numInteriorViewports = interiorViewports.size();
        Viewport viewport;
        for (int i=0; i<numInteriorViewports; i++) {
            viewport = interiorViewports.get(i);
            temp_ims = viewport.getControlMaps();
            aggregateControlMaps(ims, temp_ims);
        }
        return ims;
    }
    
    private void aggregateControlMaps(ArrayList<ControlMap> ims1, ArrayList<ControlMap> ims2) {
        int numims2 = ims2.size();
        for (int i=0; i<numims2; i++) {
            ims1.add(ims2.get(i));
        }
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
