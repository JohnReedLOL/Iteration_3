package model.map.location;

import model.entity.Entity;

/**
 * Created by Troy on 4/16/2015.
 */
public class GrassTile extends Tile {

    public boolean canPass( Entity entity ) {
        return true;
    }
}
