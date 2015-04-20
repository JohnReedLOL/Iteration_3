package model.influence_set;

import model.map.coordinate.Coordinate2D;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.direction.HexMapDirection;
import model.map.location.Location;
import model.map.location.Tile;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

/**
 * Created by Troy on 4/16/2015.
 */
public class AngularInfluenceSet extends DirectionalInfluenceSet {

    private ArrayList<Direction> directions = new ArrayList<Direction>();   //OTHER DIRECTIONS TO BE USED BY THE ANGULAR SET
    QueueInfluenceTile[][] mapInfluenceTiles;

    public AngularInfluenceSet() {
        super();
    }

    public AngularInfluenceSet( Direction direction, int radius, Location location) {
        super(direction, radius, location);
        HexCoordinate coord = getMap().getCoordinateByLocation( location );
        directions.add( direction.getCounterClockwiseDirection( coord ) );
        directions.add( direction );
        directions.add( direction.getClockwiseDirection(coord));
        initializeMapInfluenceTiles();
    }

    @Override
    public Collection<InfluenceTile> getInfluenceSet() {
        Collection<InfluenceTile> tiles = new ArrayList<InfluenceTile>();
        QueueInfluenceTile currentTile = new QueueInfluenceTile( (Tile) getSourceLocation(), 0 );

        QueueInfluenceTile iTile = new QueueInfluenceTile( (Tile) getSourceLocation(), 0) ;
        if ( getUseSourceLocation() ) { //SHould we add the center tile?
            tiles.add( iTile );
        }

        Queue<QueueInfluenceTile> queue = new ArrayDeque<QueueInfluenceTile>();
        queue.offer(currentTile);


        HexCoordinate currentCoord = null;
        HexCoordinate nextCoord = null;
        while( !queue.isEmpty() ) {
            iTile = queue.poll();
            if ( iTile.getRadius() < getRadius() ) {
                recomputeDirections(getMap().getCoordinateByLocation(iTile.getTile()));
                if ( iTile.getRadius() % 2 == 0 ) {  //for determining direction stuff: if even, go in direction. if odd, go in dir and clock/counterclockwise direcitons
                    currentCoord = getMap().getCoordinateByLocation( iTile.getTile() );
                    nextCoord = getDirection().deriveCoordinate( currentCoord );
                    if ( getMap().inBounds( nextCoord ) ) {
                        QueueInfluenceTile t = mapInfluenceTiles[nextCoord.getX()][nextCoord.getY()];
                        //System.out.println( getMap().getCoordinateByLocation(tile.getTile()).getX() + ", " + getMap().getCoordinateByLocation(tile.getTile()).getX() );
                        if ( !t.getVisited() && !tiles.contains( t ) ) {
                            t.setRadius( iTile.getRadius() + 1 );
                            tiles.add(t);
                            queue.offer(t);
                        }
                        t.setVisited( true );
                    }
                }
                else {  //we have an odd tile: get other directions, add them all.
                    for (Direction d : directions ) {
                        currentCoord = getMap().getCoordinateByLocation( iTile.getTile() );
                        nextCoord = d.deriveCoordinate( currentCoord );
                        if ( getMap().inBounds( nextCoord ) ) {
                            QueueInfluenceTile t = mapInfluenceTiles[nextCoord.getX()][nextCoord.getY()];
                            //System.out.println( getMap().getCoordinateByLocation(tile.getTile()).getX() + ", " + getMap().getCoordinateByLocation(tile.getTile()).getX() );
                            if ( !t.getVisited() && !tiles.contains( t ) ) {
                                t.setRadius( iTile.getRadius() + 1 );
                                tiles.add(t);
                                queue.offer(t);
                            }
                            t.setVisited( true );
                        }
                    }
                }
            }
        }



        return tiles;
    }

    private void recomputeDirections( HexCoordinate coordinate ) {
        directions.clear();
        HexMapDirection[] d = new HexMapDirection[] {   (HexMapDirection) getDirection(),
                                                        (HexMapDirection) getDirection().getClockwiseDirection( coordinate ),
                                                        (HexMapDirection) getDirection().getCounterClockwiseDirection( coordinate ) };
        for (int i = 0; i < d.length; ++i ) {
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
