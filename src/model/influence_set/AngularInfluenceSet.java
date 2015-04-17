package model.influence_set;

import model.map.direction.Direction;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class AngularInfluenceSet extends DirectionalInfluenceSet {

    public AngularInfluenceSet() {
        super();
    }

    public AngularInfluenceSet( Direction direction, int radius ) {
        super( direction, radius );
    }

    @Override
    public Collection<InfluenceTile> getInfluenceSet() {
        //TODO
        //SUPER LOGICS HERE

        return null;
    }
}
