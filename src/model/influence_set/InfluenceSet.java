package model.influence_set;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class InfluenceSet {

//    private GameMap map;
//    private Tile source;
    private int radius;
    private boolean source = false; //most Influence sets need not return source tile. reset this if needed.

    public InfluenceSet() {
        //DON'T USE DEFAULT CONSTRUCTOR.
        this.radius = 0;
    }

    public InfluenceSet( int radius ) {
        this.radius = radius;
    }
    public void setSource( boolean source ) {
        this.source = source;
    }

    public abstract Collection<InfluenceTile> getInfluenceSet();


}
