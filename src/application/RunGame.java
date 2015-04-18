package application;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunGame {

    /*Properties*/
    
    private static Application application;
    
    /*Constructors*/
    
    public static void main(String[] args) {
        Application.print("test");
        Application.print("RunGame started");
        application = Application.getApplication();
        application.launch(); //leads to looping threads
        
//        System.out.println("Still need to implement theads...");
//        System.exit(0);
        Application.print("Going to sleep");
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException ex) {
            System.exit(0);
        }
    }
    
    /*Methods*/
    
}
