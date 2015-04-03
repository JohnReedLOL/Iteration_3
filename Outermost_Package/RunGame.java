/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outermost_Package;

import Outermost_Package.Controller.Controller_Public;
import Outermost_Package.Model.Model_Public;
import Outermost_Package.View.View_Public;
import Outermost_Package.View.jDialog_GUI;
import Outermost_Package.View.JFrame_GUI;
import javax.swing.SwingUtilities;

/**
 *
 * @author JohnMichaelReed
 */
public class RunGame {

// <editor-fold defaultstate="collapsed" desc="Static fields">
    private static final Controller_Public controller_ = Controller_Public.getController();
    private static final Model_Public model_ = Model_Public.getModel();
    private static final View_Public view_ = Outermost_Package.View.View_Public.getView();
    //private static final JFrame_GUI gui_ = Outermost_Package.View.JFrame_GUI.get_GUI();
    private static final jDialog_GUI gui2_ = Outermost_Package.View.jDialog_GUI.get_GUI(); // View.jDialog_GUI.get_GUI();
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Non-static fields">
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Constructors">
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Accessors">
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Methods">

    /**
     * Prints the thread name, class name, method name, and line number
     */
    public static synchronized void printStackTrace() {
        final Thread current = Thread.currentThread();
        System.out.println(current.getName() + ": " + current.getStackTrace()[2] + "\n");
    }

    /**
     * Throws a runtime exception containing the entire call stack
     *
     * @param reason - Your reason for crashing the program
     */
    public static synchronized void printStackTraceAndCrashTheProgramBecause(String reason) {
        final Thread current = Thread.currentThread();
        final StackTraceElement[] s = current.getStackTrace();
        System.err.println(reason + "\n" + current.getName() + ":");
        int num_rows = 6;
        if (s.length < num_rows) {
            num_rows = s.length;
        }
        for (int i = 1; i < num_rows; ++i) {
            System.err.println(s[i].toString());
        }
        System.exit(-1);
    }

    /**
     * @param reason - Your reason for printing a stack-trace
     */
    public static synchronized void printStackTraceBecause(String reason) {
        final Thread current = Thread.currentThread();
        System.out.println(reason + "\n" + current.getName() + ": " + current.getStackTrace()[2] + "\n");
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Main">

    public static void main(String[] args) {
        Thread.currentThread().setName("Main_Thread");

        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //if(! jDialog_GUI.get_GUI().getParent().isFocusOwner() ) {
                    //    //jDialog_GUI.get_GUI().requestFocusInWindow();
                    //    RunGame.printStackTraceAndCrashTheProgramBecause("JDialog must always be in focus.");
                    //}
                }
            });
        }
        /*
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {

        }
        RunGame.printStackTraceAndCrashTheProgramBecause("Program finished");*/
    }
// </editor-fold>
}

// Copy and paste these folds when making new classes:
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
