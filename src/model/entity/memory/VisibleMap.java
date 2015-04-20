package model.entity.memory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.MapObject;
import model.entity.Entity;
import model.influence_set.InfluenceSet;
import model.influence_set.InfluenceTile;
import model.map.GameWorld;
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
		tiles = new ArrayList<Tile>();
		mapObjects = new ArrayList<List<MapObject>>();
		coordinates = new ArrayList<Coordinate2D>();
		GameWorld.getInstance().register(this);
	}
	
	public void setVision(InfluenceSet i){
		vision = i;
		update();
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
	
	public List<List<MapObject>> getMapObjects(){
		return mapObjects;
	}
	
	public void update(){
		owner.remember(this);
		vision.setSourceLocation(GameWorld.getCurrentMap().getLocationByMapObject(owner));
		Collection<InfluenceTile> iTilesSeen = vision.getInfluenceSet();
		ArrayList<Tile> tilesSeen = new ArrayList<Tile>();
		for(InfluenceTile i : iTilesSeen){
			tilesSeen.add(i.getTile());
		}
		tiles = tilesSeen;
		ArrayList<List<MapObject>> mapObjects = new ArrayList<List<MapObject>>();
		ArrayList<Coordinate2D> coords = new ArrayList<Coordinate2D>();
		for(Tile t : tiles){
			ArrayList<MapObject> tileContents = new ArrayList<MapObject>(); 
			for(MapObject m : t.getMapObjects()){
				if(m.canSee(owner)){
					tileContents.add(m);
					owner.unremember(m);
				}
			}
			mapObjects.add(tileContents);
			coords.add(GameWorld.getCurrentMap().getCoordinateByLocation(t));
		}
		this.mapObjects = mapObjects;
		coordinates = coords;
	}

	public void clear() {
		tiles.clear();
		mapObjects.clear();
		coordinates.clear();
		owner.wipeMemory();
	}
	
}
