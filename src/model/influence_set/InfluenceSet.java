package model.influence_set;

import model.map.GameMap;
import model.map.GameWorld;
import model.map.location.Location;
import model.map.location.Tile;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class InfluenceSet {

    private GameMap map;
    private Location sourceLocation;
    private int radius;
    private boolean useSourceLocation = false; //most Influence sets need not return source tile. reset this if needed.

    public InfluenceSet() {
        //DON'T USE DEFAULT CONSTRUCTOR.
        this.radius = 0;
    }

    public InfluenceSet( int radius, Location sourceLocation) {
        this.radius = radius;
        this.sourceLocation = sourceLocation;
        this.map = (GameMap) GameWorld.getCurrentMap();
    }
    public void setUseSourceLocation( boolean useSourceTile ) { 
        this.useSourceLocation = useSourceTile;
    }

    public boolean getUseSourceLocation() {
        return useSourceLocation;
    }

    public Location getSourceLocation() {
        return sourceLocation;
    }

    public int getRadius() {
        return radius;
    }

    public GameMap getMap() {
        return map;
    }

    public void setSourceLocation(Location sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public abstract Collection<InfluenceTile> getInfluenceSet();


}
