package model.map.coordinate;

import model.map.direction.Direction;

/**
 * Created by Troy on 4/18/2015.
 */
public class HexCoordinate {
    //MODEL'S COORDINATE SYSTEM: ASK TROY :)
    //POSITIVE X AXIS = DOWN
    //POSITIVE Y AXIS = NORTHEAST/WEST DEPENDING ON COORDINATE LOL

    private int x, y;

    public HexCoordinate() {
        this.x = 0;
        this.y = 0;
    }

    public HexCoordinate( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX( int x ) {
        this.x = x;
    }

    public void setY( int y ) {
        this.y = y;
    }

    public HexCoordinate getCoordinateByDirection( Direction direction ) {
        return direction.deriveCoordinate( this );
    }
}
