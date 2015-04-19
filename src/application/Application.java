package application;

// @author comcc_000

import controller.physicalController.KeyboardController;
import controller.physicalController.PhysicalController;
import model.Model;
import model.UserSettings;
import mvc_bridgeway.command.model_command.ModelCommand;
import mvc_bridgeway.control.physical_control.PhysicalControl;
import mvc_bridgeway.control_map.ControlMap;
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
    
    /**
     * Checks to see if an assertion is true. Prints stack trace and crashes the program if not true.
     * USE THIS INSTEAD OF REGULAR "assert" STATEMENTS.
     * @param assertion - assertion to be checked
     */
    public static synchronized void check(boolean assertion) {
        check(assertion, "");
    }
    
    /**
     * Checks to see if an assertion is true and prints an error message if false.
     * Also prints a stack trace and crashes the program if false.
     * @param assertion - assertion to be checked
     * @param message - error message to print
     */
    public static synchronized void check(boolean assertion, String message) {
        if(! assertion) {
            final StackTraceElement stack_trace[] = Thread.currentThread().getStackTrace();
            final int max_rows = 6;
            final int first_row = 2;
            System.err.println(message);
            System.err.println("Assertion failed in Thread: " +  Thread.currentThread().getName());
            if(stack_trace.length > max_rows) {
                for(int i = first_row; i < max_rows; ++i) {
                    System.err.println(stack_trace[i].toString());
                }
            } else {
                for(int i = first_row; i < stack_trace.length; ++i) {
                    System.err.println(stack_trace[i].toString());
                }
            }
            System.exit(-1);
        }
    }
    
    /**
     * Prints the name of the current thread and where the print statement comes from.
     * @param message - message to be printed
     */
    public static synchronized void print(String message) {
        final String thread_name = Thread.currentThread().getName() + " thread";
        final String location_of_print_statement = Thread.currentThread().getStackTrace()[2].toString();
        System.out.println(thread_name + ": " + location_of_print_statement + "\n" + message + "\n");
    }
    
    public static Application getApplication() {
        if (singleton == null) {
            return new Application();
        } else {
            throw new RuntimeException("This should only be called in the driver!");
        }
    }
    
    public void launch() {
        Application.print("Application launched");
        model.launch(this);
    }
    
    public void launchScreen(Screen screen, UserSettings userSettings) {
        screen.init(model, physicalController, userSettings);
        mainWindow.displayScreen(screen);
    }   
    
    public PhysicalControl listenForRebind(ControlMap controlMap) {
        PhysicalControl oldControl = physicalController.setupForRebind(controlMap);
        return oldControl;
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

    public UpdateTimings getUpdateTimings() {
        return updateTimings;
    }
    
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
        
        public int getFastestStep() {
            if (environmentGameStepsPerSecond > standardGameStepsPerSecond) {
                return environmentGameStepsPerSecond;
            }
            return standardGameStepsPerSecond;
        }

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
