package utility;

// @author comcc_000

import java.util.ArrayList;


public class CollectionUtil {

    /*Properties*/

    /*Constructors*/

    /*Methods*/
    
    //Converts ArrayList<Subclass> to ArrayList<Superclass>
    public static <A, B extends A> ArrayList<A> castToSuper(ArrayList<B> subclassList) {
        return new ArrayList<A>(subclassList);
    }

    /*Get-Sets*/

    /*Inner-classes*/

    /*Test Main Method*/

}
