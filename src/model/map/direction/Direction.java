package model.map.direction;

import model.map.coordinate.HexCoordinate;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class Direction {


    public abstract Direction getClockwiseDirection( HexCoordinate coordinate );
    public abstract Direction getCounterClockwiseDirection( HexCoordinate coordinate );
    public abstract Direction getOppositeDirection( HexCoordinate coordinate );
    public abstract HexCoordinate deriveCoordinate( HexCoordinate coordinate );
}
