package model.influence_set;

import model.map.direction.Direction;
import model.map.location.Location;
import model.map.location.Tile;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class AngularInfluenceSet extends DirectionalInfluenceSet {

    private Direction d1, d2;   //OTHER DIRECTIONS TO BE USED BY THE ANGULAR SET

    public AngularInfluenceSet() {
        super();
    }

    public AngularInfluenceSet( Direction direction, int radius, Location location) {
        super( direction, radius, location );
//        d1 = direction.getCounterClockwiseDirection();
//        d2 = direction.getClockwiseDirection()
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
