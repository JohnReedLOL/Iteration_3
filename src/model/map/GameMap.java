package model.map;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;
import model.MapObject;
import model.map.builder.FirstLevelMapBuilder;
import model.map.builder.MapBuilder;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.location.Location;
import model.map.location.Tile;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Troy on 4/16/2015.
 */
public class GameMap extends DiscreteMap {

    private Tile[][] tiles;
    private Map<HexCoordinate, Tile> tileMap = new HashMap<HexCoordinate, Tile>();


    public GameMap() {
        setName( generateNextMapName() );
        MapBuilder mapBuilder = getMapBuilder();
        tiles = mapBuilder.generateMap();

        for ( int i = 0; i < tiles.length; ++i ) {
            for (int j=0; j < tiles[0].length; ++j ) {
                HexCoordinate c = new HexCoordinate(i, j);
                tileMap.put(c, tiles[i][j]);
            }
        }

    }

    @Override
    public void insert( MapObject m, Location l ) {

    }

    @Override
    public void remove( MapObject m ) {

    }

    @Override
    public void relocate( MapObject m, Location l ) {

    }

    @Override
    public void move( MapObject m, Direction l ) {

    }

    @Override
    public Tile getLocationFromDirection(Location l, Direction d) {
        return null;
    }

    public Location getLocationByCoordinate ( HexCoordinate coordinate ) {
        //COULD BE RETURNED NULL! CHECK THIS
        Tile tile = tileMap.get( coordinate );
        return tile;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    private MapBuilder getMapBuilder() {
        return new FirstLevelMapBuilder();
    }

//    @Override
//    public void insert(MapObject m, Tile l) {
//
//    }
//
//    @Override
//    public void remove(MapObject m) {
//
//    }
//
//    @Override
//    public void move(MapObject m, Tile l) {
//
//    }
//
//    @Override
//    public void move(MapObject m, Direction l) {
//
//    }
}
