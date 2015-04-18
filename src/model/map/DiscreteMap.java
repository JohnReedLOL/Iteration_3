package model.map;

import model.MapObject;
import model.entity.Entity;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.location.Location;
import utility.ScalingUtil;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class DiscreteMap {
    private String name;
    private Entity avatar;

    public abstract void insert( MapObject m, Location l );
    public abstract void remove( MapObject m );
    public abstract void relocate( MapObject m, Location l);
    public abstract void move( MapObject m, Direction l);
    public abstract Location getLocationFromDirection( Location l, Direction d );

    public String getName() {
        return name;
    }

    public Entity getAvatar() {
        return this.avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(Entity avatar) {
        this.avatar = avatar;
    }

    public String generateNextMapName() {
        return "MAP_" + GameWorld.incrementMaps();
    }
}
