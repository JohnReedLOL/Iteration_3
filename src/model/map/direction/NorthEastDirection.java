package model.map.direction;

/**
 * Created by Troy on 4/16/2015.
 */
public class NorthEastDirection extends HexMapDirection {

    public NorthEastDirection() {

    }

    @Override
    public int getDeltaX() {
        return 1;
    }

    @Override
    public int getDeltaY() {
        return 0;
    }

    @Override
    public int getDeltaZ() {
        return -1;
    }

    @Override
    public Direction getClockwiseDirection() {
        return new SouthEastDirection();
    }

    @Override
    public Direction getCounterClockwiseDirection() {
        return new NorthDirection();
    }
}
