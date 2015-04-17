package model;

// @author comcc_000

import application.Application;
import mvc_bridgeway.command.Command;
import mvc_bridgeway.screen.HomeScreen;
import mvc_bridgeway.screen.Screen;


public class Model {

    /*Properties*/
    //HEEEEERE'S TROY
    
    private static Model singleton = null;
    //
    private Application application;
    private Screen currentScreen; 
    private ModelViewBundle mvb = new ModelViewBundle(); //for testing
    //
    private Mode currentMode; 
    public final RunMode RUN = new RunMode();
    public final PauseMode PAUSE = new PauseMode();

    /*Constructors*/
    
    public Model() {
        //defaults
    }

    /*Methods*/
    
        //Singleton
    
    public static Model getModel() {
        if (singleton == null) {
            return new Model();
        } else {
            throw new RuntimeException("Why are you trying to create the model again!!!???");
        }
    }
    
        //Thread operations
    
    private void updateView() {
        currentMode.updateView();
    }
    
    private void takeEnviornmentGameStep() {
        currentMode.takeEnviornmentGameStep();
    }
    
    private void takeStandardGameStep() {
        currentMode.takeStandardGameStep();
    }
    
        //Controller Interface
    
    public void queueCommandForExecution(Command command) {
        //TODO
    }
    
        //Command Interface
    
    public void exit() {
        System.exit(0);
    }
    
        //Misc
    
    public void setMode(Mode mode) {
        currentMode = mode;
    }
    
    public void launch(Application application) {
        this.application = application;
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
