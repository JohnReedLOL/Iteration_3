package model.map.location;

import model.MapObject;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class Location {

    public abstract boolean createAssociation( MapObject m );
    public abstract boolean removeAssociation( MapObject m );
    public abstract Collection<MapObject> getMapObjects();
}
