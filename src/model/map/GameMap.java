package model.map;

import application.Application;
import model.MapObject;
import model.effect.Effect;
import model.entity.Entity;
import model.influence_set.InfluenceSet;
import model.influence_set.InfluenceTile;
import model.map.builder.FirstLevelMapBuilder;
import model.map.builder.MapBuilder;
import model.map.coordinate.Coordinate2D;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.location.Location;
import model.map.location.Tile;
import utility.BidirectionalMap;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class GameMap extends DiscreteMap {

    private Tile[][] tiles;
    private int[][] brightness;
    private BidirectionalMap<HexCoordinate, Tile> tileMap = new BidirectionalMap<HexCoordinate, Tile>();

    public GameMap() {
        super();

        setName( generateNextMapName() );
        MapBuilder mapBuilder = getMapBuilder();
        tiles = mapBuilder.generateMap();
        brightness = new int[tiles.length][tiles[0].length];

        for ( int i = 0; i < tiles.length; ++i ) {
            for (int j=0; j < tiles[0].length; ++j ) {
                HexCoordinate c = new HexCoordinate(i, j);
                tileMap.insert(c, tiles[i][j]);

                boolean assertion = (tileMap.getValue(c) != null);
                Application.check(assertion);
            }
        }

        setHeight(tiles.length);
        setWidth(tiles[0].length);
    }

    @Override
    public void insert( MapObject m, Location l ) {
        l.createMapObjectAssociation(m);
    }

    @Override
    public void remove( MapObject m ) {
        Tile tile = tileMap.getValue( getMapObjectCoordinate( m ) );
        tile.removeMapObjectAssociation(m);
    }

    @Override
    public void relocate( MapObject m, Location l ) {
        l.createMapObjectAssociation(m);
    }

    @Override
    public void move( MapObject m, Coordinate2D from, Coordinate2D to ) {
        Tile previous = tileMap.getValue( (HexCoordinate) from );
        Tile newPos = tileMap.getValue( (HexCoordinate) to );

        previous.removeMapObjectAssociation( m );
        newPos.removeMapObjectAssociation(m);
        newPos.createMapObjectAssociation(m);
    }

    // Leaving here just in case it might need to be used. //
    public void move( MapObject m, Direction d ) {
        HexCoordinate prev = getMapObjectCoordinate(m);
        HexCoordinate newPos = d.deriveCoordinate(getMapObjectCoordinate(m));
        move(m, prev, newPos);
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
        Tile tile = tileMap.getValue(coordinate);
        return tile;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
    
    
    public int[][] getBrightness() {
        return brightness;
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

    @Override
    public Location getLocationByCoordinate(Coordinate2D c) {
        return tileMap.getValue( (HexCoordinate) c );
    }

    @Override
    public HexCoordinate getCoordinateByLocation(Location l) {
        Tile t = (Tile) l;
        for ( int i = 0; i < tiles.length; ++i ) {
            for (int j = 0; j < tiles[0].length; ++j ) {
                if ( tiles[i][j].equals( t ) ) {
                    return new HexCoordinate( i, j );
                }
            }
        }
        return new HexCoordinate( -1, -1 );
    }

    @Override
    public void performEffect(Effect effect, InfluenceSet influence) {
        for (InfluenceTile tile : influence.getInfluenceSet()) {
            Tile t = tile.getTile();
            Collection<MapObject> objs = t.getMapObjects();

            for (MapObject obj : objs) {
                obj.accept(effect);
            }
        }
    }


    // CAN WE DELETE THIS ALREADY?
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
