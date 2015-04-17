package Outermost_Package.Model;

import Outermost_Package.Controller.*;
import Outermost_Package.RunGame;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * This class contains functions in model that can be called from the Controller. This class is a
 * Singleton.
 */
public class Model_Public {

// <editor-fold defaultstate="collapsed" desc="Static fields">
    // This is the single instance of the enclosing Singleton
    private static Model_Public singleton_ = null;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Non-static fields">
    // You can pass runnables to this thing using .exectute(Runnable r)
    private final ExecutorService modelThread_ = newFixedThreadPool(1);
    // This contains all the stuff you don't want the other packages to know about
    private final Model_Private privateModel_ = new Model_Private();
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Constructors">

    private Model_Public () {
        modelThread_.execute(new Runnable() {
            public void run () {
                Thread.currentThread().setName("Model_Thread");
                RunGame.printStackTraceBecause("Model thread started at:");
            }
        });
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Accessors">

    /**
     * Use this function to get a reference to the Model
     *
     * @return
     */
    public static Model_Public getModel () {
        if ( singleton_ == null ) {
            singleton_ = new Model_Public();
        }
        return singleton_;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Methods">
// </editor-fold>
}

/**
 * This class contains functions in model that cannot be called from the Controller.
 *
 */
class Model_Private {
// <editor-fold defaultstate="collapsed" desc="Static fields">
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Non-static fields">
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Constructors">
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Accessors">
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Methods">
// </editor-fold>
}
