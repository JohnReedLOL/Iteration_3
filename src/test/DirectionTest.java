package test;

import model.map.coordinate.HexCoordinate;
import model.map.direction.*;

/**
 * Created by Troy on 4/18/2015.
 */
public class DirectionTest {
    public static void main(String[] args) {
        HexCoordinate evenSrc = new HexCoordinate( 1,2 );
        HexCoordinate oddSrc = new HexCoordinate( 1,1 );

        HexMapDirection[] evenDirs = new HexMapDirection[] {
                new NorthDirection( evenSrc ),
                new SouthDirection( evenSrc ),
                new NorthEastDirection( evenSrc ),
                new NorthWestDirection( evenSrc ),
                new SouthEastDirection( evenSrc ),
                new SouthWestDirection( evenSrc )
        };

        HexMapDirection[] oddDirs = new HexMapDirection[] {
                new NorthDirection( oddSrc ),
                new SouthDirection( oddSrc ),
                new NorthEastDirection( oddSrc ),
                new NorthWestDirection( oddSrc ),
                new SouthEastDirection( oddSrc ),
                new SouthWestDirection( oddSrc )
        };

        System.out.println("EVEN Y TILE");
        for( int i=0; i < evenDirs.length; ++i ) {
            System.out.println(evenDirs[i].getClass().toString() + ": " + evenDirs[i].getDeltaX() + ", " + evenDirs[i].getDeltaY());
        }

        System.out.println("ODD Y TILE");
        for( int i=0; i < oddDirs.length; ++i ) {
            System.out.println(oddDirs[i].getClass().toString() + ": " + oddDirs[i].getDeltaX() + ", " + oddDirs[i].getDeltaY());
        }

//        HexCoordinate coord = new HexCoordinate( 4,4 );
//        HexMapDirection derived = new NorthDirection( coord );
//        System.out.println( derived.getDeltaX() + ", " + derived.getDeltaY());
    }

}
