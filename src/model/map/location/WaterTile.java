package model.map.location;

import model.entity.Entity;
import model.map.direction.Direction;

/**
 * Created by Troy on 4/16/2015.
 */
public class WaterTile extends Tile {

    private int flowRate;
    private Direction direction;

    public boolean canPass( Entity entity ) {
        return false;
    }
}
