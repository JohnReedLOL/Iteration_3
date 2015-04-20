package model.entity.behavior.movement;

import model.entity.Entity;
import model.map.DiscreteMap;
import model.map.GameWorld;
import model.map.coordinate.Coordinate2D;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;

public class FlyingBehavior extends MovementBehavior {
    /**
     * PROPERTIES
     */

    private static FlyingBehavior singleton = null;

    /**
     * CONSTRUCTORS
     */

    private FlyingBehavior() {

    }

    /**
     * GETTERS
     */

    public static FlyingBehavior getInstance() {
        if (singleton == null) {
            setFlyingBehavior();
        }

        return singleton;
    }

    /**
     * MUTATORS
     */

    private static void setFlyingBehavior() {
        singleton = new FlyingBehavior();
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public boolean move(Entity entity, Direction direction) {
    	entity.setDirection(direction);
        DiscreteMap map = GameWorld.getCurrentMap();

        if (map.withinBounds(entity, direction)) {
            Coordinate2D previous = map.getMapObjectCoordinate(entity);
            Coordinate2D toMove = direction.deriveCoordinate((HexCoordinate) previous);

            map.move(entity, previous, toMove);
            return true;
        }

        return false;
    }
}
