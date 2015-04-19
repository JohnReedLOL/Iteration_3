package model.influence_set;

import model.map.coordinate.HexCoordinate;
import model.map.direction.*;
import model.map.location.Location;
import model.map.location.Tile;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

/**
 * Created by Troy on 4/16/2015.
 */
public class RadialInfluenceSet extends InfluenceSet {

    private ArrayList<HexMapDirection> directions = new ArrayList<HexMapDirection>();
    private QueueInfluenceTile[][] mapInfluenceTiles;


    public RadialInfluenceSet() {
        super();
    }

    public RadialInfluenceSet( int radius, Location location ) {
        super(radius, location);

    }

    @Override
    public Collection<InfluenceTile> getInfluenceSet() {
        Collection<InfluenceTile> tiles = new ArrayList<InfluenceTile>();
        initializeMapInfluenceTiles();

        QueueInfluenceTile iTile = new QueueInfluenceTile( (Tile) getSourceLocation(), 0 );
        if ( getUseSourceLocation() ) {
            tiles.add(iTile);
        }
        iTile.setVisited( true );

        Queue<QueueInfluenceTile> queue = new ArrayDeque<QueueInfluenceTile>();

        queue.offer(iTile);

        while( !queue.isEmpty() ) {
            iTile = queue.poll();                                                                   //GRAB QUEUE ITEM
            if ( iTile.getRadius() < getRadius() ) {                                                //IF WE ARE STILL IN DESIRED RADIUS OF INFLUENCESET
                updateDirections( getMap().getCoordinateByLocation( iTile.getTile() ) );            //DYNAMICALLY COMPUTE DIRECTION DELTAS
                for (HexMapDirection d : directions) {                                              //FOR EACH DIRECTION, TRY ADDING TO RETURN SET / QUEUE
                    HexCoordinate currentCoord = getMap().getCoordinateByLocation(iTile.getTile()); //GET QUEUE ITEM'S COORDINATES
                    HexCoordinate nextCoord = d.deriveCoordinate(currentCoord);                     //DERIVE NEW COORDINATES BASED ON OLD COORDINATES AND DIRECTIONS
                    if ( getMap().inBounds( nextCoord ) ) {                                         //MAKE SURE WE DON'T GO OUT OF BOUNDS
                        QueueInfluenceTile t = mapInfluenceTiles[nextCoord.getX()][nextCoord.getY()]; //GET THAT INFLUENCE TILE
                        //t.setRadius( iTile.getRadius() + 1 );                                       //RADIUS IS ONE FARTHER THAN QUEUE ITEM'S
                        if ( !t.getVisited() && !tiles.contains( t ) ) {
                            t.setRadius( iTile.getRadius() + 1 ); //IF OUR INFLUENCE TILE IS NOT VISITED AND WE DON'T HAVE T IN THE SET
                            tiles.add(t);                                                           //ADD THE TILE TO RETURN SET
                            queue.offer( t );                                                       //ADD TILE TO QUEUE
                        }
                        t.setVisited( true );                                                       //MARK TILE AS VISITED ANYWAYS
                    }
                }
            }
        }


        return tiles;
    }

    private void updateDirections( HexCoordinate coord ) {
        directions.clear();
        HexMapDirection[] d = new HexMapDirection[] {   new NorthDirection( coord ),
                                                        new NorthWestDirection( coord ),
                                                        new SouthWestDirection( coord ),
                                                        new SouthDirection( coord ),
                                                        new SouthEastDirection( coord ),
                                                        new NorthEastDirection( coord ) };
        for ( int i = 0; i < d.length; ++i ) {
            directions.add( d[i] );
        }
    }

    private void initializeMapInfluenceTiles() {
        Tile[][] someTiles = getMap().getTiles();
        mapInfluenceTiles = new QueueInfluenceTile[someTiles.length][someTiles[0].length];

        for( int i = 0; i < someTiles.length; ++i ) {
            for( int j = 0; j < someTiles[0].length; ++j ) {
                mapInfluenceTiles[i][j] = new QueueInfluenceTile( someTiles[i][j] );
            }
        }
    }
}
