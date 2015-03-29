/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outermost_Package;

/**
 *
 * @author JohnMichaelReed
 */
public class RunGame {
    
    public static void printStackTrace() {
        final Thread current = Thread.currentThread();
        System.out.println(current.getName() + ": " + current.getStackTrace()[2]);
    }
    
    public static void printStackTraceAndCrashTheProgram() {
        printStackTrace();
        System.exit(-1);
    }
    
    public static void main(String [] args) {
        Thread.currentThread().setName("Main_Thread");
        printStackTraceAndCrashTheProgram();
    }
    
}
