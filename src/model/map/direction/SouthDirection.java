package model.map.direction;

import model.map.coordinate.HexCoordinate;

/**
 * Created by Troy on 4/16/2015.
 */
public class SouthDirection extends HexMapDirection {

    public SouthDirection() {
        super(new HexCoordinate(0, 0));
    }

    public SouthDirection( HexCoordinate coordinate ) {
        super( coordinate );
    }



    @Override
    public Direction getClockwiseDirection( HexCoordinate coordinate ) {
        return new SouthWestDirection( coordinate );
    }

    @Override
    public Direction getCounterClockwiseDirection( HexCoordinate coordinate ) {
        return new SouthEastDirection( coordinate );
    }

    @Override
    public Direction getOppositeDirection( HexCoordinate coordinate ) {
        return new NorthDirection( coordinate );
    }

    @Override
    public HexCoordinate deriveCoordinate( HexCoordinate coordinate ) {
        return new HexCoordinate( coordinate.getX() + 1, coordinate.getY() );
    }
}
