package model.entity.behavior.movement;

import model.entity.Entity;
import model.entity.behavior.Behavior;
import model.map.DiscreteMap;
import model.map.GameWorld;
import model.map.direction.Direction;

public abstract class MovementBehavior extends Behavior {
	/**
	 * CONSTRUCTORS
	 */

	/**
	 * IMPLEMENTATIONS
	 */

	public abstract boolean move(Entity target, Direction direction);
}
