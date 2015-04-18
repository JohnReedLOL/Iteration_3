package model.map;

import model.MapObject;
import model.map.location.Tile;

/**
 * Created by Troy on 4/16/2015.
 */
public class TileMapObjectAssociation {

    private Tile tile;
    private MapObject mapObject;

    public TileMapObjectAssociation( Tile tile, MapObject mapObject ) {
        this.tile = tile;
        this.mapObject = mapObject;
    }

    public Tile getTile() {
        return tile;
    }

    public MapObject getMapObject() {
        return mapObject;
    }

}
