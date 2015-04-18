package model.entity.behavior.movement;

import model.entity.Entity;
import model.map.DiscreteMap;
import model.map.GameMap;
import model.map.GameWorld;
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
    public void move(Entity entity, Direction direction) {
        DiscreteMap map = GameWorld.getCurrentMap();

        if (map.withinBounds(entity, direction)) {
            map.move(entity, direction);
        }
    }
}
