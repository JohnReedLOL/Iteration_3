package model.entity.movement;

import model.entity.Entity;
import model.map.direction.Direction;

public class ClassicMovement extends Movement{
	public void move(Direction direction, Entity target){
		getCurrentMap().move(target, direction);
	}
}
