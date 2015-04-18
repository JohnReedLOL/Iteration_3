package model.entity.movement;

import model.entity.Entity;
import model.map.DiscreteMap;
import model.map.GameWorld;
import model.map.direction.Direction;

public abstract class Movement {
	protected DiscreteMap getCurrentMap(){
		return GameWorld.getInstance().getCurrentMap();
	}
	public abstract void move(Direction direction, Entity target);
}
