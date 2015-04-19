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

    public AngularInfluenceSet() {
        super();
    }

    public AngularInfluenceSet( Direction direction, int radius, Location location) {
        super( direction, radius, location );
        HexCoordinate coord = getMap().getCoordinateByLocation( location );
        directions.add( direction.getCounterClockwiseDirection( coord ) );
        directions.add( direction );
        directions.add(direction.getClockwiseDirection(coord));
    }

    @Override
    public Collection<InfluenceTile> getInfluenceSet() {
        Collection<InfluenceTile> tiles = new ArrayList<InfluenceTile>();
        InfluenceTile currentTile = new InfluenceTile( (Tile) getSourceLocation(), 0 );

        if ( getUseSourceLocation() ) { //SHould we add the center tile?
            tiles.add( currentTile );
        }

        Queue<InfluenceTile> queue = new ArrayDeque<InfluenceTile>();
        queue.offer(currentTile);

        Tile next = currentTile.getTile();

        while( !queue.isEmpty() ) {
            if ( queue.peek().getRadius() < getRadius() ) {
                InfluenceTile grabbed = queue.poll();
                //recomputeDirections( grabbed );
                if ( grabbed.getRadius() % 2 == 0 ) {  //for determining direction stuff: if even, go in direction. if odd, go in dir and clock/counterclockwise direcitons
                    next = getMap().getLocationFromDirection( grabbed.getTile(), getDirection() );
                    if ( next != null ) {
                        InfluenceTile tile = new InfluenceTile( next, grabbed.getRadius() + 1 );
                        System.out.println( getMap().getCoordinateByLocation(tile.getTile()).getX() + ", " + getMap().getCoordinateByLocation(tile.getTile()).getX() );
                        tiles.add( tile );
                        queue.offer( tile );
                    }
                }
                else {  //we have an odd tile: get other directions, add them all.
                    for (Direction d : directions ) {
                        next = getMap().getLocationFromDirection( grabbed.getTile(), d );
                        if ( next != null ) {
                            InfluenceTile tile = new InfluenceTile( next, grabbed.getRadius() + 1 );
                            System.out.println( getMap().getCoordinateByLocation(tile.getTile()).getX() + ", " + getMap().getCoordinateByLocation(tile.getTile()).getX() );
                            tiles.add( tile );
                            queue.offer(tile);
                        }
                    }
                }
            }
            else queue.poll();
        }



        return tiles;
    }

    private void recomputeDirections( InfluenceTile grabbed ) {
        HexCoordinate coord = getMap().getCoordinateByLocation( grabbed.getTile() );
        for (Direction d : directions ) {
            ( (HexMapDirection) d ).recomputeDelta( coord );
        }
    }
}
