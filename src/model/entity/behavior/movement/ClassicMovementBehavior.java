package model.entity.behavior.movement;

import model.entity.Entity;
import model.map.direction.Direction;

public class ClassicMovementBehavior extends MovementBehavior {
	/**
	 * CONSTRUCTOR
	 */

	public void move(Entity target, Direction direction){
		getCurrentMap().move(target, direction);
	}
}
