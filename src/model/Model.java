package model;

// @author comcc_000
import application.Application;
import application.Application.UpdateTimings;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingUtilities;

import model.entity.Entity;
import model.entity.ability.Ability;
import model.entity.avatar.Avatar;
import model.item.Item;
import model.item.sackbound.SackboundItem;
import model.map.GameWorld;
import model.map.direction.Direction;
import mvc_bridgeway.command.model_command.ModelCommand;
import mvc_bridgeway.control_map.ControlMap;
import mvc_bridgeway.screen.HomeScreen;
import mvc_bridgeway.screen.Screen;
import model.factories.OccupationFactory;
import model.item.sackbound.equip.EquipItem;
import model.map.GameMap;
import model.map.location.Location;
import view.utility.stat.Stat;

public class Model {

    /*Properties*/
    private static Model singleton = null;
    //
    private static final String model_thread_name_ = "Model Modifier";
    private static final String model_clock_thread_name_ = "Model Clock";
    private static final ExecutorService model_thread_ = Executors.newSingleThreadExecutor();
    private static final ExecutorService model_clock_ = Executors.newSingleThreadExecutor();
    private static ConcurrentLinkedQueue<ModelCommand> to_execute_ = new ConcurrentLinkedQueue<ModelCommand>();
    private static final ExecutorService viewClock_ = Executors.newSingleThreadExecutor();
    private final static int refreshTime_ = 60;
    public static final String view_clock_name = "View_Clock";

    static {
        viewClock_.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(view_clock_name);
            }
        });
    }

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
    private ModelViewBundle mvb = ModelViewBundle.getInstance(); //for testing
    //
    public final RunMode RUN = new RunMode();
    public final PauseMode PAUSE = new PauseMode();
    private Mode currentMode = RUN;

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
                            if (!to_execute_.isEmpty()) {
                                for (ModelCommand command : to_execute_) {
                                    command.execute();
                                }
                                // After executing, set it to null
                                // probabaly better to implement commands in a queue 
                                // and remove done command from queue
                                to_execute_.clear();
                                takeEnviornmentGameStep();
                                takeStandardGameStep();

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

    public static Avatar getAvatar() {
        return GameWorld.getAvatar();
    }

    // Thread operations
    private synchronized void updateView() {
        currentMode.updateView();
    }

    private synchronized void takeEnviornmentGameStep() {
        currentMode.takeEnviornmentGameStep();
    }

    private synchronized void takeStandardGameStep() {
        currentMode.takeStandardGameStep();
    }

    // Controller Interface
    public synchronized void queueCommandForExecution(ModelCommand command) {
        // TODO: better to implement as a queue?
        
        to_execute_.add(command); // store command to be executed when the model
    }

    // Command Interface
    public void exit() {
        System.exit(0);
    }

    public void setupPhysicalControllerForRebind(ControlMap controlMap) {
        UserSettings userSettings = mvb.getUserSettings();
        userSettings.updateForRebind(controlMap);
        //
        application.listenForRebind(controlMap);
    }

    public void save(File file) {
        // TODO
        String filename = file.getAbsolutePath();
    }

    public void load(File file) {
        // TODO
        String filename = file.getAbsolutePath();
    }

    public void setSneakOccupation(Entity entity) {
        Application.print("User created Sneak");
        entity.setInstance(OccupationFactory.generateAvatarSneakOccupation());
    }

    public void setSummonerOccupation(Entity entity) {
        Application.print("User created Summoner");
        entity.setInstance(OccupationFactory.generateAvatarSummonerOccupation());
    }

    public void setSmasherOccupation(Entity entity) {
        Application.print("User created Smasher");
        entity.setInstance(OccupationFactory.generateAvatarSmasherOccupation());
    }

    public void beginNewGame() {
        // TODO
    }

    public void levelupStat(Stat stat) {
        stat.level();
    }

	// /* -------------------- LEVEL UP COMMANDS -------------------- */
    // public void levelStrength(Entity a) {
    // a.getStatsOwnership().upStrength();
    // }
    //
    // public void levelAgility(Entity a) {
    // a.getStatsOwnership().upAgility();
    // }
    public boolean move(Entity entity, Direction direction) {
        entity.move(direction);
        return true;
    }

    public boolean storeInInventory(Avatar avatar, SackboundItem item) {
        return avatar.getInventoryOwnership().addItem(item);
    }

    public boolean equip(Avatar avatar, Item item) {
        item.apply(avatar);
        return true;
    }

    public void unequip(Avatar avatar, EquipItem item) {
        avatar.getArmoryOwnership().unequip(item);
    }

    public void drop(Avatar avatar) {

    }

    public void dismount(Avatar avatar) {
        avatar.dismount();
    }

    public boolean activateAbility(Avatar avatar, Ability ability) {
        avatar.useAbility(ability);
        return false;
    }

    public void talk() {
        Avatar avatar = mvb.getAvatar();
        GameMap gameMap = mvb.getMap();
        Direction direction = avatar.getDirection();
        Location avatarLocation = gameMap.getLocationByMapObject(avatar);
        Location targetLocation = gameMap.getLocationFromDirection(avatarLocation, direction);
        ArrayList<MapObject> mapObjects = (ArrayList<MapObject>) targetLocation.getMapObjects();
        if (mapObjects != null && !mapObjects.isEmpty()) {
            MapObject target = mapObjects.get(0);
            if (target != null) {
                mvb.setCurrentDialogue(target.talk());
            }
        }
    }

    public boolean purchase(Avatar avatar, Item item, int price) {
        // TODO
        return false;
    }

    // Misc
    public void setMode(Mode mode) {
        currentMode = mode;
    }

    public void launch(Application application) {
        this.application = application;
        startTheClock(application.getUpdateTimings());
        launchFirstScreen();
        Model.viewClock_.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(refreshTime_);
//						SwingUtilities.invokeLater(new Runnable() {
//							@Override
//							public void run() {
                        currentScreen.updateView(mvb);
//							}
//						});
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void launchFirstScreen() {
        Screen firstScreen = new HomeScreen();
        launchScreen(firstScreen);
    }

    public void launchScreen(Screen screen) {
        currentScreen = screen;
        application.launchScreen(screen, mvb.getUserSettings());
    }

    /* Get-Sets */

    /* Inner-classes */
    private abstract class Mode { // Begin Mode Inner-Class

        protected abstract void updateView();

        protected abstract void takeEnviornmentGameStep();

        protected abstract void takeStandardGameStep();

    } // End Mode Inner-Class

    private class RunMode extends Mode { // Begin RunMode Inner-Class

        @Override
        protected final void updateView() {
            currentScreen.updateView(mvb);
        }

        @Override
        protected void takeEnviornmentGameStep() {

        }

        @Override
        protected final void takeStandardGameStep() {
            GameWorld.getCurrentMap().onMapTick();
        }

    } // End RunMode Inner-Class

    private class PauseMode extends Mode { // Begin RunMode Inner-Class

        @Override
        protected final void updateView() {
            currentScreen.updateView(mvb);
        }

        @Override
        protected final void takeEnviornmentGameStep() {
            // Do nothing
        }

        @Override
        protected final void takeStandardGameStep() {
            // Do nothing
        }

    } // End RunMode Inner-Class

    /* Test Main Method */
}
