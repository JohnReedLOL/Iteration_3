package Outermost_Package.Model;
import Outermost_Package.Controller.*;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;
/**
 * This class contains functions in model that can be called from the Controller. 
 * This class is a Singleton.
 */
public class Model_Public {
    // You can pass runnables to this thing using .exectute(Runnable r)
    private final ExecutorService modelThread_ = newFixedThreadPool(1);
    // This contains all the stuff you don't want the other packages to know about
    private final Model_Private privateModel_ = new Model_Private();
    // This is the single instance of the enclosing Singleton
    private static Model_Public singleton_ = null;
    private Model_Public() {
        
    }
    /**
     * Use this function to get a reference to the Model
     * @return 
     */
    public static Model_Public getModel() {
        if(singleton_ == null) {
            singleton_ = new Model_Public();
        }
        return singleton_;
    }
}

/**
 * This class contains functions in model that cannot be called from the Controller.
 *
 */
class Model_Private {
    
}
