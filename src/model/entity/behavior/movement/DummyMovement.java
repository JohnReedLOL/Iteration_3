package model.entity.behavior.movement;

import model.entity.Entity;
import model.map.direction.Direction;

public class DummyMovement extends MovementBehavior {
    /**
     * PROPERTIES
     */

    private static DummyMovement singleton = null;

    /**
     * CONSTRUCTOR
     */

    private DummyMovement() {}

    /**
     * GETTERS
     */

    public static DummyMovement getInstance() {
        if (singleton == null) {
            singleton = new DummyMovement();
        }

        return singleton;
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public boolean move(Entity target, Direction direction) {
        return false;
    }
}
