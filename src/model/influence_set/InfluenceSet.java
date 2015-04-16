package model.influence_set;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class InfluenceSet {

//    private GameMap map;
//    private Tile source;
    private int radius;

    public abstract Collection<InfluenceTile> getInfluenceSet();
}
