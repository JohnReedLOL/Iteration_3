package model.entity.behavior.movement;

import model.entity.Entity;
import model.map.DiscreteMap;
import model.map.GameWorld;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.location.Tile;

public class ClassicMovementBehavior extends MovementBehavior {

	/**
	 * PROPERTIES
	 */

	private static ClassicMovementBehavior singleton = null;

	/**
	 * CONSTRUCTOR
	 */

	private ClassicMovementBehavior() {

	}

	/**
	 * GETTERS
	 */

	public static ClassicMovementBehavior getInstance() {
		if (singleton == null) {
			singleton = new ClassicMovementBehavior();
		}

		return singleton;
	}

	/**
	 * IMPLEMENTATIONS
	 */

	public void move(Entity target, Direction direction) {
		DiscreteMap map = GameWorld.getCurrentMap();
		HexCoordinate prev = (HexCoordinate) map.getMapObjectCoordinate(target);
		HexCoordinate candidate = direction.deriveCoordinate(prev);
		Tile tile = (Tile) map.getLocationByCoordinate(candidate);

		if (!map.withinBounds(target, direction) || !tile.canPass(target)) {
			return;
		}

		map.move(target, prev, candidate);
	}
}
