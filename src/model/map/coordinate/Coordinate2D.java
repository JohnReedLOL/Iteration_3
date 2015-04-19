package model.map.coordinate;

import model.map.direction.Direction;

/**
 * Created by Troy on 4/18/2015.
 */
public abstract class Coordinate2D {

    private int x, y;

    public Coordinate2D() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinate2D( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    public abstract Coordinate2D getCoordinateByDirection( Direction direction );

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals( Object object ) {
        if ( object instanceof Coordinate2D ) {
            Coordinate2D c = (Coordinate2D) object;
            if (x == c.getX() && y == c.getY()) {
                return true;
            }
        }
        return false;
    }
}
