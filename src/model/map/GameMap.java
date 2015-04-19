package model.map;

import model.MapObject;
import model.map.builder.FirstLevelMapBuilder;
import model.map.builder.MapBuilder;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.location.Location;
import model.map.location.Tile;
import utility.BidirectionalMap;
import utility.ScalingUtil;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class GameMap extends DiscreteMap {

    private Tile[][] tiles;
    private BidirectionalMap<HexCoordinate, Tile> tileMap = new BidirectionalMap<HexCoordinate, Tile>();

    public GameMap() {
        super();

        setName( generateNextMapName() );
        MapBuilder mapBuilder = getMapBuilder();
        tiles = mapBuilder.generateMap();

        for ( int i = 0; i < tiles.length; ++i ) {
            for (int j=0; j < tiles[0].length; ++j ) {
                HexCoordinate c = new HexCoordinate(i, j);
                tileMap.insert(c, tiles[i][j]);
            }
        }

        setHeight(tiles.length);
        setWidth(tiles[0].length);
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
    public void move( MapObject m, Direction d ) {

    }

    @Override
    public void teleport(MapObject m, DiscreteMap d) {
        //TODO
    }

    @Override
    public Tile getLocationFromDirection(Location l, Direction d) {
        Tile tile = (Tile) l;
        HexCoordinate coord = tileMap.getKey(tile);

        HexCoordinate newLoc = d.deriveCoordinate( coord );
        return tileMap.getValue( newLoc );
    }

    public Location getLocationByCoordinate ( HexCoordinate coordinate ) {
        //COULD BE RETURNED NULL! CHECK THIS
        Tile tile = tileMap.getValue( coordinate );
        return tile;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    private MapBuilder getMapBuilder() {
        return new FirstLevelMapBuilder();
    }

    @Override
    public boolean withinBounds(MapObject m, Direction d) {
        HexCoordinate coord = getMapObjectCoordinate(m);
        HexCoordinate candidate = d.deriveCoordinate(coord);

        return (candidate.getX() > -1 && candidate.getX() < getWidth() &&
                candidate.getY() > -1 && candidate.getY() < getHeight());
    }

    public HexCoordinate getMapObjectCoordinate( MapObject mapObject ) {
        //FIND IF MAPOBJECT IS CONTAINED, ELSE RETURNS NULL
        Collection<Tile> tiles = tileMap.values();
        for ( Tile t: tiles ) {
            if (t.contains( mapObject ) ) {
                return tileMap.getKey(t);
            }
        }
        return new HexCoordinate(-1,-1);
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
