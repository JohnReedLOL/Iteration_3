package model.map.location;

import model.entity.Entity;

/**
 * Created by Troy on 4/16/2015.
 */
public class MountainTerrain extends Tile {

    public boolean canPass(Entity entity) {
        return false;
    }
}
