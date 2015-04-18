package model.map.builder;

import model.map.GameMap;
import model.map.location.GrassTile;
import model.map.location.Tile;
import model.map.location.WaterTile;

/**
 * Created by Troy on 4/17/2015.
 */
public class FirstLevelMapBuilder extends MapBuilder {


    @Override
    public Tile[][] generateMap() {
        //TODO: MAKE THIS DO SOMETHING USEFUL
        Tile[][] tiles = new Tile[30][30];
        for ( int i = 0; i < tiles.length; ++i ) {
            for ( int j = 0; j < tiles[0].length; ++j ) {
                tiles[i][j] = new GrassTile();
            }
        }

        tiles[5][5] = new WaterTile();
        return tiles;

    }
}
