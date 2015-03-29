package Outermost_Package.View;
import Outermost_Package.Controller.*;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;
/**
 * This class contains functions that can be called from the Controller. 
 * This class is a Singleton.
 */
public class View_Public {
    // You can pass runnables to this thing using .exectute(Runnable r)
    private final ExecutorService viewThread_ = newFixedThreadPool(1);
    // This contains all the stuff you don't want the other packages to know about
    private final View_Private privateView_ = new View_Private();
    // This is the single instance of the enclosing Singleton
    private static View_Public singleton_ = null;
    private View_Public() {
        
    }
    /**
     * Use this function to get a reference to the View
     * @return 
     */
    public static View_Public getView() {
        if(singleton_ == null) {
            singleton_ = new View_Public();
        }
        return singleton_;
    }
}

/**
 * This class contains functions that cannot be called from the Controller.
 *
 */
class View_Private {
    
}
