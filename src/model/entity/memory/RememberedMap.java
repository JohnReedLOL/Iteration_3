package model.entity.memory;

import java.util.List;

import model.MapObject;
import model.entity.Entity;
import model.map.coordinate.Coordinate2D;
import model.map.location.Tile;

public class RememberedMap {
	private Entity owner;
	private List<Tile> tiles;
	private List<List<MapObject>> mapObjects;
	private List<Coordinate2D> coordinates;
	
	public RememberedMap(Entity o){
		owner = o;
	}
	
	public void remember(VisibleMap sight){
		for(int i = 0; i < sight.getTiles().size(); ++i){
			Tile current = sight.getTiles().get(i);
			if(!tiles.contains(current)){
				tiles.add(current);
				coordinates.add(sight.getCoordinates().get(i));
			}
			int index = tiles.indexOf(current);
			mapObjects.set(index,sight.getMapObjects().get(i));
		}
	}
}
