package model.entity.memory;

import java.util.List;

import model.MapObject;
import model.entity.Entity;
import model.influence_set.InfluenceSet;
import model.map.coordinate.Coordinate2D;
import model.map.location.Tile;

public class VisibleMap {
	private InfluenceSet vision;
	private Entity owner;
	private List<Tile> tiles;
	private List<List<MapObject>> mapObjects;
	private List<Coordinate2D> coordinates;
	
	public VisibleMap(InfluenceSet i, Entity o){
		vision = i;
		owner = o;
	}
	
	public void setVision(InfluenceSet i){
		vision = i;
	}
	
	public InfluenceSet getVision(){
		return vision;
	}
	
	public List<Tile> getTiles(){
		return tiles;
	}
	
	public List<Coordinate2D> getCoordinates(){
		return coordinates;
	}
	
	public void update(){
		List<Tile> tilesSeen;
	}
	
}
