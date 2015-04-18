package model.map.builder;

import model.map.location.GrassTile;
import model.map.location.Tile;
import model.map.location.WaterTile;
import utility.ScalingUtil;

/**
 * Created by Troy on 4/17/2015.
 */
public class FirstLevelMapBuilder extends MapBuilder {
    @Override
    public Tile[][] generateMap() {
        return generateMap(ScalingUtil.MAP_DEFAULT_HEIGHT, ScalingUtil.MAP_DEFAULT_WIDTH);
    }

    public Tile[][] generateMap(int height, int width) {
        //TODO: MAKE THIS DO SOMETHING USEFUL
        Tile[][] tiles = new Tile[height][width];
        for ( int i = 0; i < tiles.length; ++i ) {
            for ( int j = 0; j < tiles[0].length; ++j ) {
                tiles[i][j] = new GrassTile();
            }
        }

        tiles[5][5] = new WaterTile();
        return tiles;
    }
}
