package Outermost_Package.View;

import Outermost_Package.Controller.*;
import Outermost_Package.RunGame;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * This class contains functions that can be called from the Controller. This class is a Singleton.
 */
public class View_Public {

// <editor-fold defaultstate="collapsed" desc="Static fields">
    private static View_Public singleton_ = null;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Non-static fields">
    // contains package private stuff
    private final View_Private privateView_ = new View_Private();
    // You can pass runnables to this thing using .exectute(Runnable r)
    private final ExecutorService viewThread_ = newFixedThreadPool(1);
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Constructors">

    private View_Public () {
        viewThread_.execute(new Runnable() {
            public void run () {
                Thread.currentThread().setName("View_Thread");
                RunGame.printStackTraceBecause("View thread started at:");
            }
        });
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Accessors">

    /**
     * Use this function to get a reference to the
     *
     * @return
     */
    public static View_Public getView () {
        if ( singleton_ == null ) {
            singleton_ = new View_Public();
        }
        return singleton_;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Methods">
// </editor-fold>
}

/**
 * This class contains functions that cannot be called from the Controller.
 *
 */
class View_Private {
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
