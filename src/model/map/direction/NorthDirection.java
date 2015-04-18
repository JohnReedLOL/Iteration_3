package model.map.direction;

import model.map.coordinate.HexCoordinate;

/**
 * Created by Troy on 4/16/2015.
 */
public class NorthDirection extends HexMapDirection {

    public NorthDirection( HexCoordinate coordinate ) {
        super( coordinate );
    }


    @Override
    public Direction getClockwiseDirection( HexCoordinate coordinate ) {
        return new NorthEastDirection( coordinate );
    }

    @Override
    public Direction getCounterClockwiseDirection( HexCoordinate coordinate ) {
        return new NorthWestDirection( coordinate );
    }

    @Override
    public Direction getOppositeDirection( HexCoordinate coordinate ) {
        return new SouthDirection( coordinate );
    }

    @Override
    public HexCoordinate deriveCoordinate( HexCoordinate coordinate ) {
        return new HexCoordinate( coordinate.getX() - 1, coordinate.getY() );
    }
}
