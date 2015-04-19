package model.map.coordinate;

import model.map.direction.Direction;

/**
 * Created by Troy on 4/18/2015.
 */
public abstract class Coordinate2D {

    private int x, y;

    public abstract Coordinate2D getCoordinateByDirection( Direction direction );

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
