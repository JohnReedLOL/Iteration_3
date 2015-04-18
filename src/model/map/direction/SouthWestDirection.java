package model.map.direction;

import model.map.coordinate.HexCoordinate;

/**
 * Created by Troy on 4/16/2015.
 */
public class SouthWestDirection extends HexMapDirection {

    public SouthWestDirection( HexCoordinate coordinate ) {
        super( coordinate );
    }

    @Override
    public Direction getClockwiseDirection( HexCoordinate coordinate ) {
        return new NorthWestDirection( coordinate );
    }

    @Override
    public Direction getCounterClockwiseDirection( HexCoordinate coordinate ) {
        return new SouthDirection( coordinate );
    }

    @Override
    public Direction getOppositeDirection( HexCoordinate coordinate ) {
        return new NorthEastDirection( coordinate );
    }

    @Override
    public HexCoordinate deriveCoordinate(HexCoordinate coordinate) {
        return ( coordinate.getY() % 2 == 0) ?
                new HexCoordinate( coordinate.getX(), coordinate.getY() - 1) :   //IF IT'S AN EVEN Y
                new HexCoordinate( coordinate.getX() + 1, coordinate.getY() - 1);    //IF IT'S AN ODD Y
    }
}
