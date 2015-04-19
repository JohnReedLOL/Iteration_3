package model.map.builder;

import model.entity.npc.NPC;
import model.map.location.GrassTile;
import model.map.location.MountainTile;
import model.map.location.Tile;
import model.map.location.WaterTile;

/**
 * Created by Troy on 4/19/2015.
 */
public class SecondLevelMapBuilder extends MapBuilder {

    @Override
    public Tile[][] generateMap() {
        Tile[][] map = new Tile[50][50];

        for (int i = 0; i < map.length; ++i ) {
            for ( int j = 0; j < map[0].length; ++j ) {
                if ( i < 3 || j < 3 ) {
                    map[i][j] = new MountainTile();
                }
                map[i][j] = new WaterTile();
            }
        }

        for ( int j = 0; j < map[0].length; ++j ) {
            map[5][j] = new GrassTile();
            map[6][j] = new GrassTile();
            map[7][j] = new GrassTile();

            map[15][j] = new GrassTile();
            map[16][j] = new GrassTile();
            map[17][j] = new GrassTile();
        }
        for ( int i = 0; i < map[0].length; ++i ) {
            map[i][39] = new GrassTile();
            map[i][40] = new GrassTile();
            map[i][41] = new GrassTile();

            map[i][44] = new GrassTile();
            map[i][43] = new GrassTile();
            map[i][42] = new GrassTile();
        }

        map[6][40].createMapObjectAssociation( new NPC( "NPC", "NPC Test") );
        map[16][43].createMapObjectAssociation( new NPC( "NPC", "NPC Test 2" ) );


        return map;
    }
}
