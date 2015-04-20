package model.map;

import application.Application;
import model.MapObject;
import model.effect.Effect;
import model.influence_set.InfluenceSet;
import model.influence_set.InfluenceTile;
import model.map.builder.FirstLevelMapBuilder;
import model.map.builder.MapBuilder;
import model.map.coordinate.Coordinate2D;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.location.GrassTile;
import model.map.location.Location;
import model.map.location.MountainTile;
import model.map.location.Tile;
import utility.BidirectionalMap;
import utility.CoordUtil;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class GameMap extends DiscreteMap {

    private Tile[][] tiles;
    private BidirectionalMap<HexCoordinate, Tile> tileMap = new BidirectionalMap<HexCoordinate, Tile>();

    public GameMap() {
        super();
    }

    @Override
    public void populate() {
        setName( generateNextMapName() );
        MapBuilder mapBuilder = getMapBuilder();
        tiles = mapBuilder.generateMap();

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
        if (l != null) {
            l.createMapObjectAssociation(m);
        }
    }

    @Override
    public void remove( MapObject m ) {
        Tile tile = tileMap.getValue(getMapObjectCoordinate(m));
        tile.removeMapObjectAssociation(m);
    }

    @Override
    public void move( MapObject m, Coordinate2D from, Coordinate2D to ) {
        Tile previous = tileMap.getValue( (HexCoordinate) from );
        Tile newPos = tileMap.getValue( (HexCoordinate) to );

        previous.removeMapObjectAssociation(m);
        newPos.removeMapObjectAssociation(m);

        for ( MapObject mapObject : newPos.getMapObjects() ) {
            mapObject.interact( m );
        }

        newPos.createMapObjectAssociation(m);

        GameWorld.updateVisibleMap();
    }

    // Leaving here just in case it might need to be used. //
    public void move( MapObject m, Direction d ) {
        HexCoordinate prev = getMapObjectCoordinate(m);
        HexCoordinate newPos = d.deriveCoordinate(getMapObjectCoordinate(m));
        move(m, prev, newPos);
    }

    @Override
    public void teleport(MapObject m, DiscreteMap d) {
        //OVERRIDE THIS METHOD IN ANY GAMEMAP SUBCLASSES TO CORRECTLY PLACE YOUR AVATAR ON A TELEPORT.
        remove( m );
        d.insert( m , d.getPreferredTeleportLocation() );
    }

    @Override
    public Tile getLocationFromDirection(Location l, Direction d) {
        Tile tile = (Tile) l;
        HexCoordinate coord = tileMap.getKey(tile);

        HexCoordinate newLoc = d.deriveCoordinate(coord);
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

    protected MapBuilder getMapBuilder() {
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
        if (l != null) {
            Tile t = (Tile) l;
            for (int i = 0; i < tiles.length; ++i) {
                for (int j = 0; j < tiles[0].length; ++j) {
                    if (tiles[i][j].equals(t)) {
                        return new HexCoordinate(i, j);
                    }
                }
            }
        }
        return new HexCoordinate( -1, -1 );
    }

    @Override
    public Location getLocationByMapObject( MapObject m ) {
        return getLocationByCoordinate( getMapObjectCoordinate( m ) );
    }

    @Override
    public Location getPreferredTeleportLocation() {
        return getLocationByCoordinate( CoordUtil.MAP_1_DEFAULT_COORDINATE );
    }

    @Override
    public int getDistance(MapObject m1, MapObject m2) {
        HexCoordinate h1 = getMapObjectCoordinate( m1 );
        HexCoordinate h2 = getMapObjectCoordinate( m2 );

        if (h1.getX() == -1 || h1.getY() == -1 || h2.getX() == -1 || h2.getY() == -1)
            return -1;

        return (int) Math.sqrt( Math.pow( h1.getX() - h2.getX(), 2) + Math.pow( h1.getY() - h2.getY(), 2) );
    }

    public void performEffect(Effect effect, InfluenceSet influence) {
        for (InfluenceTile tile : influence.getInfluenceSet()) {
            Tile t = tile.getTile();
            Collection<MapObject> objs = t.getMapObjects();

            for (MapObject obj : objs) {
                obj.accept(effect);
            }
        }
    }

    public void testBiMap() {
        tileMap = new BidirectionalMap< HexCoordinate, Tile >();

        GrassTile grassTile = new GrassTile();
        MountainTile mountainTile = new MountainTile();
        tileMap.insert( new HexCoordinate( 3, 9 ), grassTile );
        tileMap.insert( new HexCoordinate( 5, 5 ), mountainTile );

        HexCoordinate t = tileMap.getKey( mountainTile );
        System.out.println( t.getX() + ", " + t.getY() );
    }

    public boolean inBounds( HexCoordinate coord ) {
        if ( coord.getX() >= 0 && coord.getX() < getHeight()  &&
           ( coord.getY() >= 0 && coord.getY() < getWidth() ) ) {
            return true;
        }
        return false;

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
