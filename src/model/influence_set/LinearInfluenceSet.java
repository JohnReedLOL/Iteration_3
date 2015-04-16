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

    public LinearInfluenceSet( Direction direction ) {
        super( direction );
    }

    @Override
    public Collection<InfluenceTile> getInfluenceSet() {
        //TODO
        //ENTER SUPER LOGICS HERE

        return null;
    }
}
