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


    public RadialInfluenceSet() {
        super();
    }

    public RadialInfluenceSet( int radius, Location location ) {
        super(radius, location);
    }

    @Override
    public Collection<InfluenceTile> getInfluenceSet() {
        Collection<InfluenceTile> tiles = new ArrayList<InfluenceTile>();

        QueueInfluenceTile iTile = new QueueInfluenceTile( (Tile) getSourceLocation(), 0 );
        if ( getUseSourceLocation() ) {
            tiles.add( iTile );
            iTile.setVisited( true );
        }

        Queue<QueueInfluenceTile> queue = new ArrayDeque<QueueInfluenceTile>();

        queue.add( iTile );

        while( !queue.isEmpty() ) {
            iTile = queue.poll();
            if ( iTile.getRadius() < getRadius()  && iTile.getVisited()) {
                updateDirections( getMap().getCoordinateByLocation( iTile.getTile() ) );
                for (HexMapDirection d : directions) {
                    Tile next = getMap().getLocationFromDirection(iTile.getTile(), d);
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
}
