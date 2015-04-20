package model.entity.behavior.ai;

import model.MapObject;
import model.entity.ClassicEntity;
import model.entity.Entity;
import model.entity.npc.pet.Pet;
import model.map.GameMap;
import model.map.GameWorld;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.direction.NorthDirection;
import model.map.direction.NorthEastDirection;
import model.map.direction.NorthWestDirection;
import model.map.direction.SouthDirection;
import model.map.direction.SouthEastDirection;
import model.map.direction.SouthWestDirection;

public class DefaultPetBehavior extends DecisionBehavior {

	public void makeBestDecision(Entity entity){
		Pet target = (Pet) entity;
		//chase after the closest thing to your owner
		ClassicEntity owner = target.getOwnership().getOwner();
		MapObject closest = null;
		double closestdist = Double.MAX_VALUE;
		//search for the closest thing that you can see to your owner
		for(MapObject m : target.getVisibleMapObjects()){
			double distance = GameWorld.getCurrentMap().getDistance(owner, m);
			if(distance >= 0 && distance < closestdist ) {
				closestdist = distance;
				closest = m;
			}	
		}
		if(closest != null){
			Direction toMove = null;
			HexCoordinate targetCoord = (HexCoordinate) GameWorld.getCurrentMap().getCoordinateByLocation(GameWorld.getCurrentMap().getLocationByMapObject(target));
			HexCoordinate sourceCoord = (HexCoordinate) GameWorld.getCurrentMap().getCoordinateByLocation(GameWorld.getCurrentMap().getLocationByMapObject(closest));
			double deltaX = sourceCoord.getX() - targetCoord.getX();
			double deltaY = sourceCoord.getY() - targetCoord.getY();
			deltaX += deltaX > 0 ? .1 : -.1;
			deltaY += deltaY > 0 ? .1 : -.1;
			double ratio = deltaX/deltaY;
			if(ratio > 0 && ratio >= 2 && deltaX > 0) toMove = new NorthDirection(targetCoord);
			else if(ratio > 0 && ratio >= 2 && deltaX < 0) toMove = new SouthDirection(targetCoord);
			else if(ratio > 0 && ratio < 2 && deltaX > 0) toMove = new SouthEastDirection(targetCoord);
			else if(ratio > 0 && ratio < 2 && deltaX < 0) toMove = new NorthWestDirection(targetCoord);
			else if(ratio < 0 && ratio <= -2 && deltaX < 0) toMove = new NorthWestDirection(targetCoord);
			else if(ratio < 0 && ratio <= -2 && deltaX > 0) toMove = new NorthWestDirection(targetCoord);
			else if(ratio < 0 && ratio > -2 && deltaX < 0) toMove = new NorthEastDirection(targetCoord);
			else if(ratio < 0 && ratio > -2 && deltaX > 0) toMove = new SouthWestDirection(targetCoord);
			else return;
			GameWorld.getCurrentMap().move(target, toMove);
		}
		
	}
}
