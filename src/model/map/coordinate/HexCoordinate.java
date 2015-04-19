package model.map.coordinate;

import model.map.direction.Direction;

/**
 * Created by Troy on 4/18/2015.
 */
public class HexCoordinate extends Coordinate2D {
    //MODEL'S COORDINATE SYSTEM: ASK TROY :)
    //POSITIVE X AXIS = DOWN
    //POSITIVE Y AXIS = NORTHEAST/WEST DEPENDING ON COORDINATE LOL


    public HexCoordinate() {
        super(0,0);
    }

    public HexCoordinate( int x, int y ) {
        super( x, y );
    }

    public HexCoordinate(HexCoordinate coord) {
        super(coord);
    }

    public Coordinate2D getCoordinateByDirection( Direction direction ) {
        return direction.deriveCoordinate( this );
    }

    @Override
    public boolean equals( Object object ) {
        if ( object instanceof HexCoordinate ) {
            HexCoordinate c = ( HexCoordinate ) object;
            if ( getX() == c.getX() && getY() == c.getY() ) {
                return true;
            }
        }

        return false;
    }
}
