package application;

// @author comcc_000

import controller.physicalController.KeyboardController;
import controller.physicalController.PhysicalController;
import model.Model;
import model.UserSettings;
import mvc_bridgeway.command.model_command.ModelCommand;
import mvc_bridgeway.command.model_command.RebindCommand;
import mvc_bridgeway.screen.Screen;
import view.MainWindow;


public class Application {

    /*Properties*/
    
    private static Application singleton;
    //
    private Model model;
    private PhysicalController physicalController;
    private MainWindow mainWindow;
    private UpdateTimings updateTimings;

    /*Constructors*/
    
    private Application() {
        model = initModel();
        physicalController = initPhysicalController();
        mainWindow = initMainWindow();
        updateTimings = initUpdateTimings();
    }

    /*Methods*/
    
    public static Application getApplication() {
        if (singleton == null) {
            return new Application();
        } else {
            throw new RuntimeException("This should only be called in the driver!");
        }
    }
    
    public void launch() {
        System.out.println("Application launched");
        model.launch(this);
    }
    
    public void launchScreen(Screen screen, UserSettings userSettings) {
        screen.init(model, physicalController, userSettings);
        mainWindow.displayScreen(screen);
    }   
    
    public void listenForRebind(RebindCommand rebindCommand) {
        //TODO
    }
    
    private Model initModel() {
        Model model = Model.getModel();
        ModelCommand.setModel(model); //parameterize
        return model;
    }
    
    private PhysicalController initPhysicalController() {
        return new KeyboardController(model);
    }
    
    private MainWindow initMainWindow() {
        return new MainWindow();
    }
    
    private UpdateTimings initUpdateTimings() {
        int viewUpdatesPerSecond = 20;
        int environmentGameStepsPerSecond = 3;
        int standardGameStepsPerSecond = 1;
        return new UpdateTimings(viewUpdatesPerSecond, environmentGameStepsPerSecond, standardGameStepsPerSecond);
    }

    /*Get-Sets*/

    /*Inner-classes*/
    
    public class UpdateTimings { //Begin UpdateTimings Inner-Class
        
        /*Properties*/
        
        private int viewUpdatesPerSecond;
        private int environmentGameStepsPerSecond;
        private int standardGameStepsPerSecond;
        
        /*Constructor*/
        
        public UpdateTimings(int viewUpdatesPerSecond, int environmentGameStepsPerSecond, int standardGameStepsPerSecond) {
            this.viewUpdatesPerSecond = viewUpdatesPerSecond;
            this.environmentGameStepsPerSecond = environmentGameStepsPerSecond;
            this.standardGameStepsPerSecond = standardGameStepsPerSecond;
        }
        
        /*Methods*/

        public int getViewUpdatesPerSecond() {
            return viewUpdatesPerSecond;
        }

        public void setViewUpdatesPerSecond(int viewUpdatesPerSecond) {
            this.viewUpdatesPerSecond = viewUpdatesPerSecond;
        }

        public int getEnvironmentGameStepsPerSecond() {
            return environmentGameStepsPerSecond;
        }

        public void setEnvironmentGameStepsPerSecond(int environmentGameStepsPerSecond) {
            this.environmentGameStepsPerSecond = environmentGameStepsPerSecond;
        }

        public int getStandardGameStepsPerSecond() {
            return standardGameStepsPerSecond;
        }

        public void setStandardGameStepsPerSecond(int standardGameStepsPerSecond) {
            this.standardGameStepsPerSecond = standardGameStepsPerSecond;
        }  
        
    } //End UpdateTimings Inner-Class

}
