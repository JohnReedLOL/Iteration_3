package model.map.direction;

/**
 * Created by Troy on 4/16/2015.
 */
public class SouthWestDirection extends HexMapDirection {

    public SouthWestDirection() {

    }

    @Override
    public int getDeltaX() {
        return -1;
    }

    @Override
    public int getDeltaY() {
        return 0;
    }

    @Override
    public int getDeltaZ() {
        return 1;
    }
}
