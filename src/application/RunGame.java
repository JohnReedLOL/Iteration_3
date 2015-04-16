package application;

public class RunGame {

    /*Properties*/
    
    private static Application application;
    
    /*Constructors*/
    
    public static void main(String[] args) {
        System.out.println("RunGame started");
        application = Application.getApplication();
        application.launch(); //leads to looping threads
        
//        System.out.println("Still need to implement theads...");
//        System.exit(0);
    }
    
    /*Methods*/
    
}
