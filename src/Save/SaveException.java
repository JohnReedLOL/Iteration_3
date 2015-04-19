package Save;

public class SaveException extends Exception{
    public SaveException(String s) {
        super(s);
    }

    public SaveException(Exception e) {
        super(e);
    }
}
