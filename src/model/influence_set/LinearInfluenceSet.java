package model.influence_set;

import model.map.direction.Direction;
import model.map.location.Location;
import model.map.location.Tile;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class LinearInfluenceSet extends DirectionalInfluenceSet {

    public LinearInfluenceSet() {
        super();
    }

    public LinearInfluenceSet( Direction direction, int radius, Location location) {
        super( direction, radius, location );
    }

    @Override
    public Collection<InfluenceTile> getInfluenceSet() {
        Collection<InfluenceTile> tiles = new ArrayList<InfluenceTile>();

        if ( getUseSourceLocation() ) {
            tiles.add( new InfluenceTile( (Tile) getSourceLocation(), 0 ) );
        }

        Tile source = (Tile) getSourceLocation();
        for( int i = 0; i < getRadius(); ++i ) {
            Tile tile = getMap().getLocationFromDirection( source, getDirection() );
            if ( tile != null ) {
                tiles.add( new InfluenceTile( tile, i ) );
                source = tile;
            }
            else {    //YOU HIT THE END OF THE MAP DUMBASS
                break;
            }
        }

        return tiles;
    }
}
