package Outermost_Package.Controller;

import Outermost_Package.View.*;
import Outermost_Package.Model.*;
import Outermost_Package.RunGame;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * This class contains functions that can be called from outside the Controller. This class is a
 * Singleton.
 */
public class Controller_Public {

// <editor-fold defaultstate="collapsed" desc="Static fields">
    // This is the single instance of the enclosing Singleton
    private static Controller_Public singleton_ = null;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Non-static fields">
    // You can pass runnables to this thing using .exectute(Runnable r)
    private final ExecutorService controllerThread_ = newFixedThreadPool(1);
    // This contains all the stuff you don't want the other packages to know about
    private final Controller_Private privateController_ = new Controller_Private();
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Constructors">

    private Controller_Public () {
        controllerThread_.execute(new Runnable() {
            public void run () {
                Thread.currentThread().setName("Controller_Thread");
                RunGame.printStackTraceBecause("Controller thread started at:");
            }
        });
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Accessors">

    /**
     * Use this function to get a reference to the controller
     *
     * @return
     */
    public static Controller_Public getController () {
        if ( singleton_ == null ) {
            singleton_ = new Controller_Public();
        }
        return singleton_;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Methods">
// </editor-fold>

}

/**
 * This class contains functions that cannot be called from outside the Controller.
 *
 */
class Controller_Private {
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
