/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outermost_Package;

import Outermost_Package.Controller.Controller_Public;
import Outermost_Package.Model.Model_Public;
import Outermost_Package.View.View_Public;

/**
 *
 * @author JohnMichaelReed
 */
public class RunGame {

    private static final Model_Public model_ = Model_Public.getModel();
    private static final View_Public view_ = View_Public.getView();
    private static final Controller_Public controller_ = Controller_Public.getController();

    /**
     * Prints the thread name, class name, method name, and line number
     */
    public static synchronized void printStackTrace () {
        final Thread current = Thread.currentThread();
        System.out.println(current.getName() + ": " + current.getStackTrace()[2] + "\n");
    }
    
    /**
     * @param reason - Your reason for printing a stack-trace
     */
    public static synchronized void printStackTraceBecause(String reason) {
        final Thread current = Thread.currentThread();
        System.out.println(reason + "\n" + current.getName() + ": " + current.getStackTrace()[2] + "\n");
    }

    public static synchronized void printStackTraceAndCrashTheProgram () {
        final Thread current = Thread.currentThread();
        System.err.println(current.getName() + ":");
        throw new RuntimeException();
    }

    /**
     * @param reason - reason for crashing the program
     */
    public static synchronized void printStackTraceAndCrashTheProgramBecause ( String reason ) {
        final Thread current = Thread.currentThread();
        System.err.println(reason + "\n" + current.getName() + ":");
        throw new RuntimeException();
    }

    public static void main ( String[] args ) {
        Thread.currentThread().setName("Main_Thread");
        RunGame.printStackTraceAndCrashTheProgramBecause("Program finished");
    }

}
