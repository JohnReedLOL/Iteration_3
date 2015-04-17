package model.influence_set;

import model.map.direction.Direction;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class LinearInfluenceSet extends DirectionalInfluenceSet {

    public LinearInfluenceSet() {
        super();
    }

    public LinearInfluenceSet( Direction direction, int radius ) {
        super( direction, radius );
    }

    @Override
    public Collection<InfluenceTile> getInfluenceSet() {
        //TODO
        //ENTER SUPER LOGICS HERE

        return null;
    }

    @Override
    public Collection<InfluenceTile> getInfluenceSetNoSource() {
        //TODO
        //LOGIC STUFFS HERE

        return null;
    }
}
