package model;

// @author comcc_000
import application.Application;
import application.Application.UpdateTimings;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.entity.Entity;
import model.item.Item;
import model.map.GameWorld;
import model.map.direction.Direction;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.control_map.ControlMap;
import mvc_bridgeway.screen.HomeScreen;
import mvc_bridgeway.screen.Screen;

public class Model {

    /*Properties*/

    private static Model singleton = null;
    //
    private static final String model_thread_name_ = "Model Modifier";
    private static final String model_clock_thread_name_ = "Model Clock";
    private static final ExecutorService model_thread_ = Executors.newSingleThreadExecutor();
    private static final ExecutorService model_clock_ = Executors.newSingleThreadExecutor();
    private static volatile Command to_execute_ = null;
    static {
        // name model thread
        Runnable name_setter = new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(model_thread_name_);
                Application.print("name set!");
            }
        };
        model_thread_.execute(name_setter);
        // name model clock
        Runnable clock_name_setter = new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(model_clock_thread_name_);
                Application.print("name set!");
            }
        };
        model_clock_.execute(clock_name_setter);

    }
    //
    private Application application;
    private Screen currentScreen;
    private ModelViewBundle mvb = new ModelViewBundle(); //for testing
    //
    private Mode currentMode;
    public final RunMode RUN = new RunMode();
    public final PauseMode PAUSE = new PauseMode();

    /*Constructors*/
    private Model() {
        //defaults
    }

    /**
     * Starts the clock that runs the model.
     */
    private void startTheClock(UpdateTimings updateTimings) {
        final int numUpdatesPerSecond = updateTimings.getFastestStep();
        final int sleepTimeInMs = 1000 / numUpdatesPerSecond;
        final int num_repeats = 3;

        Runnable clock_runner = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //for (int i = 0; i < num_repeats; ++i) {
                    try {
                        Thread.sleep(sleepTimeInMs);
                    } catch (InterruptedException ie) {

                    }
                    //}
                    Runnable turn_taker = new Runnable() {
                        @Override
                        public void run() {
                            if (to_execute_ != null) {
                                to_execute_.execute();
                                // After executing, set it to null
                                // probabaly better to implement commands in a queue 
                                // and remove done command from queue
                                to_execute_ = null;
                                // update the screen after executing command.
                                currentScreen.getViewport().update(mvb);
                            }
                        }
                    };
                    model_thread_.execute(turn_taker);
                }
            }
        };
        model_clock_.execute(clock_runner);
    }

    /*Methods*/
    
        //Singleton
    
    public static Model getModel() {
        if (singleton == null) {
            singleton = new Model();
        }
//       else {
//            throw new RuntimeException("Why are you trying to create the model again!!!???");
//        }

        return singleton;
    }

    public static Entity getAvatar() {
        return GameWorld.getAvatar();
    }

        //Thread operations
    
    private synchronized void updateView() {
        currentMode.updateView();
    }

    private synchronized void takeEnviornmentGameStep() {
        currentMode.takeEnviornmentGameStep();
    }

    private synchronized void takeStandardGameStep() {
        currentMode.takeStandardGameStep();
    }

        //Controller Interface
    
    public synchronized void queueCommandForExecution(Command command) {
        // TODO: better to implement as a queue?
        to_execute_ = command; // store command to be executed when the model clock tells it to execute AKA lag compensation
        //command.execute(); //for now
    }

        //Command Interface
    
    public void exit() {
        System.exit(0);
    }

    public void setupPhysicalControllerForRebind(ControlMap controlMap) {
        application.listenForRebind(controlMap);
    }
    
    public void save() {
        //TODO
    }
    
    public void load() {
        //TODO
    }
    
//    public void setOccupation(Entity entity, Occupation occupation) {
//        //TODO
//    }
    
    public void beginNewGame() {
        //TODO
    }
    
    public boolean move(Entity entity, Direction direction) {
        //TODO
        return false;
    }
    
//    public boolean storeInInventory(Avatar avatar, Item item) {
//        //TODO
//        return false;
//    }
//    
//    public boolean equip(Avatar avatar, Item item) {
//        //TODO
//        return false;
//    }
//    
//    public void drop(Avatar avatar, Item item) {
//        //TODO
//    }
//    
//    public boolean activateAbility(Avatar avatar, Ability ability) {
//        //TODO
//        return false;
//    }
//    
//    public void talk(Avatar avatar, Ability ability) {
//        //TOdO
//    }
//    
//    public boolean purchase(Avatar avatar, Item item, int price) {
//        //TODO
//        return false;
//    }

        //Misc
    
    public void setMode(Mode mode) {
        currentMode = mode;
    }

    public void launch(Application application) {
        this.application = application;
        startTheClock(application.getUpdateTimings());
        launchFirstScreen();
    }

    private void launchFirstScreen() {
        Screen firstScreen = new HomeScreen();
        launchScreen(firstScreen);
    }

    public void launchScreen(Screen screen) {
        currentScreen = screen;
        application.launchScreen(screen, mvb.getUserSettings());
    }

    /*Get-Sets*/

    /*Inner-classes*/
    private abstract class Mode { //Begin Mode Inner-Class

        protected abstract void updateView();

        protected abstract void takeEnviornmentGameStep();

        protected abstract void takeStandardGameStep();

    } //End Mode Inner-Class

    private class RunMode extends Mode { //Begin RunMode Inner-Class

        @Override
        protected final void updateView() {
            currentScreen.updateView(mvb);
        }

        @Override
        protected void takeEnviornmentGameStep() {
            //TODO
        }

        @Override
        protected final void takeStandardGameStep() {
            //TODO
        }

    } //End RunMode Inner-Class

    private class PauseMode extends Mode { //Begin RunMode Inner-Class

        @Override
        protected final void updateView() {
            currentScreen.updateView(mvb);
        }

        @Override
        protected final void takeEnviornmentGameStep() {
            //Do nothing
        }

        @Override
        protected final void takeStandardGameStep() {
            //Do nothing
        }

    } //End RunMode Inner-Class

    /*Test Main Method*/
}
