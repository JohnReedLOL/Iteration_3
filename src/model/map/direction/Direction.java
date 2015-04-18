package model.map.direction;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class Direction {
    //Simply defines an abstract type

    public abstract Direction getClockwiseDirection();
    public abstract Direction getCounterClockwiseDirection();
    public abstract Direction getOppositeDirection();
}
