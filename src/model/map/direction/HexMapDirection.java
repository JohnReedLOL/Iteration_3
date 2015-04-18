package model.map.direction;

import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class HexMapDirection extends Direction {

//    NEW SCHEMA
//    2D REPRESENTATION
//
//    Ask Troy for any questions.


    private int deltaX ,deltaY;

    public HexMapDirection( HexCoordinate coordinate ) {
        HexCoordinate c = deriveCoordinate( coordinate );
        setDeltaX( c.getX() - coordinate.getX() );
        setDeltaY( c.getY() - coordinate.getY() );
    }

    //FINAL GET METHODS
    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    private void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    private void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }
}
