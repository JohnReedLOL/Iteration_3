package model.map.direction;

/**
 * Created by Troy on 4/16/2015.
 */
public class NorthWestDirection extends HexMapDirection {

    public NorthWestDirection() {

    }

    @Override
    public int getDeltaX() {
        return -1;
    }

    @Override
    public int getDeltaY() {
        return 1;
    }

    @Override
    public int getDeltaZ() {
        return 0;
    }

    @Override
    public Direction getClockwiseDirection() {
        return new NorthDirection();
    }

    @Override
    public Direction getCounterClockwiseDirection() {
        return new SouthWestDirection();
    }
}
