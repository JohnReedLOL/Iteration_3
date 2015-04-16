package model.map.direction;

import model.map.direction.Direction;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class HexMapDirection extends Direction {

//    READ ME!
//    HexMapDirections are in terms of a 3D representation of Hex Tiles.
//    These tiles lay flat.
//    The east facing direction is the positive X Direction.
//    The northwest facing direction is the positive Y Direction.
//    The southwest facing direction is the positive Z Direction.

//    POSITIVE Y          NEGATIVE Z
//                _ _ _
//              /       \
// NEGATIVE X  /         \   POSITIVE X
//             \         /
//              \ _ _ _ /
//
//    POSITIVE Z          NEGATIVE Y
//
//    Ask Troy for any questions.




    //FINAL GET METHODS
    public abstract int getDeltaX();

    public abstract int getDeltaY();

    public abstract int getDeltaZ();
}
