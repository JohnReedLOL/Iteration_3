package Load;

public class LoadException extends Exception{

   public LoadException(String s) {
     super(s);
   }

    public LoadException(Exception e) {
       super(e);
    }

}
