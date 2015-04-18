package model.entity.behavior;

import model.entity.Entity;
import model.map.DiscreteMap;
import model.map.GameWorld;

public abstract class Behavior {
    /**
     * PROPERTIES
     */

    /**
     * CONSTRUCTORS
     */

    /**
     * GETTERS
     */

    protected static DiscreteMap getCurrentMap() {
        return GameWorld.getCurrentMap();
    }

    /**
     * MUTATORS
     */

    /**
     * IMPLEMENTATIONS
     */
}
