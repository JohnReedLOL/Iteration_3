package model.influence_set;

import model.map.location.Location;
import model.map.location.Tile;

/**
 * Created by Troy on 4/19/2015.
 */
public class QueueInfluenceTile extends InfluenceTile {
    private boolean visited = false;

    public QueueInfluenceTile(Tile tile) {
        super( tile );
    }

    public QueueInfluenceTile( Tile tile, int radius ) {
        super( tile, radius );
    }

    public void setVisited( boolean visited ) {
        this.visited = visited;
    }

    public boolean getVisited() {
        return visited;
    }
}
