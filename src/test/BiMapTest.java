package test;

import utility.BidirectionalMap;

/**
 * Created by Troy on 4/18/2015.
 */
public class BiMapTest {

    public static void main(String[] args) {
        BidirectionalMap<String, Integer> map = new BidirectionalMap<String, Integer>();

//        String troy = "TROY";

        map.insert( "TROY", new Integer(5));

        System.out.println(map.getKey( 5 ));
    }
}
