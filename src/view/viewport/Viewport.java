package view.viewport;

// @author comcc_000

import java.util.ArrayList;
import javax.swing.JPanel;
import model.ModelViewBundle;
import mvc_bridgeway.command.view_command.ViewCommand;
import mvc_bridgeway.control_map.ControlMap;


public abstract class Viewport extends JPanel {
    
    /*Properties*/
    
    protected boolean refreshControllerNeeded = false;

    /*Constructors*/
    
    public Viewport() {
        // TODO Auto-generated constructor stub
    }
    
    /*Methods*/
    
    public abstract void update(ModelViewBundle mvb);
    public abstract ArrayList<ControlMap> getControlMaps();
    protected abstract void generateView();
    
    public static final void queueCommandForExecution(ViewCommand command) {
        command.execute(); //for now
    }
    
    public final boolean isRefreshControllerNeeded() {
        return refreshControllerNeeded;
    }
    
    protected void addViewport(Viewport viewport) {
        setProperties();
        add(viewport);
    }
    
    private void setProperties(){
        this.setSize( 1500, 1500);
    }  

}
