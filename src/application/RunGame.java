package application;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class RunGame {

    /*Properties*/
    
    private static Application application;
    
    /*Constructors*/
    
    public static void main(String[] args) {
        Application.print("RunGame started");
        application = Application.getApplication();
        application.launch(); //leads to looping threads
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("GUI / Event_Dispatch");
            }
        });
        putMainThreadToSleep();
    }
    
    /*Methods*/
    
    private static void putMainThreadToSleep() {
        //Safely put main thread to sleep; background threads will take it from here
        Application.print("Going to sleep");
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException ex) {
            System.exit(0);
        }
    }
    
}
