package model.map;

import model.MapObject;
import model.map.direction.Direction;
import model.map.location.Location;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class DiscreteMap {

    private String name;

    public abstract void insert( MapObject m, Location l );
    public abstract void remove( MapObject m );
    public abstract void move( MapObject m, Location l);
    public abstract void move( MapObject m, Direction l);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
