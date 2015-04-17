package model.influence_set;

import model.map.direction.Direction;
import model.map.direction.NorthDirection;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class DirectionalInfluenceSet extends InfluenceSet {

    private Direction direction;

    public DirectionalInfluenceSet() {
        //Default for safety - DO NOT USE!
        this.direction = new NorthDirection();
    }

    public DirectionalInfluenceSet( Direction direction, int radius ) {
        super( radius );
        this.direction = direction;

    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
