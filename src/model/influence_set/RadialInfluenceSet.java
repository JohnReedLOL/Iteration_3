package model.influence_set;

import model.map.direction.Direction;
import model.map.location.Location;
import model.map.location.Tile;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class RadialInfluenceSet extends InfluenceSet {


    public RadialInfluenceSet() {
        super();
    }

    public RadialInfluenceSet( int radius, Location location ) {
        super( radius, location );
    }

    @Override
    public Collection<InfluenceTile> getInfluenceSet() {
        Collection<InfluenceTile> tiles = new ArrayList<InfluenceTile>();

        if ( getUseSourceLocation() ) {
            tiles.add( new InfluenceTile( (Tile) getSourceLocation(), 0 ) );
        }

        return null;
    }
}
