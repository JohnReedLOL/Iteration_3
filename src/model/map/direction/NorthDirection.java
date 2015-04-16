package model.map.direction;

/**
 * Created by Troy on 4/16/2015.
 */
public class NorthDirection extends HexMapDirection {

    public NorthDirection() {

    }


    @Override
    public int getDeltaX() {
        return 0;
    }

    @Override
    public int getDeltaY() {
        return 1;
    }

    @Override
    public int getDeltaZ() {
        return -1;
    }
}
