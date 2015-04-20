package model.entity;


import java.util.ArrayList;
import java.util.List;

import model.MapObject;
import model.armory.ArmoryOwnership;
import model.effect.Effect;
import model.entity.ability.Ability;
import model.entity.ability.AbilityLibrary;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.behavior.movement.MovementBehavior;
import model.entity.detection.Detection;
import model.entity.memory.RememberedMap;
import model.entity.memory.VisibleMap;
import model.entity.stats.StatsOwnership;
import model.entity.stats.StatsVisitor;
import model.influence_set.RadialInfluenceSet;
import model.inventory.InventoryOwnership;
import model.item.sackbound.SackboundItem;
import model.map.GameMap;
import model.map.GameWorld;
import model.map.coordinate.Coordinate2D;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.direction.NorthEastDirection;
import model.map.direction.SouthEastDirection;
import model.map.location.GrassTile;
import utility.CoordUtil;

public abstract class Entity extends MapObject {
	private ArmoryOwnership armoryOwnership;
	private InventoryOwnership inventoryOwnership;
	private StatsOwnership statsOwnership;
	private Detection detectionMechanism;
	private MovementBehavior movementBehavior;
	private RememberedMap memory;
	private VisibleMap sight;
	private AbilityLibrary abilities;
	private Direction direction;
	private int booty;
        
	/* -------------------- CONSTRUCTORS -------------------- */
	public Entity(HexCoordinate location){
		GameWorld.getCurrentMap().insert(this, GameWorld.getCurrentMap().getLocationByCoordinate(location));
		armoryOwnership = new ArmoryOwnership(this);
		inventoryOwnership = new InventoryOwnership(this);
		statsOwnership = new StatsOwnership(this);
		detectionMechanism = new Detection();
		movementBehavior = ClassicMovementBehavior.getInstance();
		memory = new RememberedMap(this);
		sight = new VisibleMap(new RadialInfluenceSet(5,GameWorld.getCurrentMap().getLocationByMapObject(this)),this);
		abilities = new AbilityLibrary(this);
		direction = new NorthEastDirection((HexCoordinate) (GameWorld.getCurrentMap().getCoordinateByLocation(GameWorld.getCurrentMap().getLocationByMapObject(this))));

		this.booty = 0;
	}

	/* -------------------- GETTERS -------------------- */

	public ArmoryOwnership getArmoryOwnership() {
		return this.armoryOwnership;
	}

	public InventoryOwnership getInventoryOwnership() {
		return this.inventoryOwnership;
	}

	public Detection getDetectionMechanism() {
		return this.detectionMechanism;
	}

	public MovementBehavior getMovementBehavior() {
		return this.movementBehavior;
	}

	public StatsOwnership getStatsOwnership() {
		return this.statsOwnership;
	}
	
	public List<Ability> getLearnedAbilities(){
		return abilities.getLearnedAbilities();
	}
	
	public List<Ability> getUnlearnedAbilities(){
		return abilities.getUnlearnedAbilities();
	}

	public int getBooty() {
		return this.booty;
	}

	/* -------------------- SETTERS -------------------- */

	public void setDetectionMechanism(Detection detection) {
		this.detectionMechanism = detection;
	}

	public void setMovementBehavior(MovementBehavior movement) {
		this.movementBehavior = movement;
	}

	public void setStatsOwnership(StatsOwnership ownership) {
		this.statsOwnership = ownership;
	}

	public void setSight(VisibleMap visibility) {
		this.sight = visibility;
	}

	public void setMemory(RememberedMap remembered) {
		this.memory = remembered;
	}

	private void setArmoryOwnership(ArmoryOwnership ownership) {
		this.armoryOwnership = ownership;
	}

	private void setInventoryOwnership(InventoryOwnership ownership) {
		this.inventoryOwnership = ownership;
	}

	public void setInstance(Entity entity) {
		setDetectionMechanism(entity.getDetectionMechanism());
		setMovementBehavior(entity.getMovementBehavior());
		setInventoryOwnership(entity.getInventoryOwnership());
		setArmoryOwnership(entity.getArmoryOwnership());
	}

	public void setBooty(int booty) {
		this.booty = booty;
	}
	/* -------------------- COMMANDS -------------------- */
	public void move(Direction direction){
		this.direction = direction;
		movementBehavior.move(this, direction);
		System.out.println("I just moved");
	}
	
	public void drop(SackboundItem item){
		GameWorld.getCurrentMap().insert(inventoryOwnership.removeItem(item),GameWorld.getCurrentMap().getLocationByMapObject(this));
	}
	
	public void useAbility(Ability ability){
		abilities.useAbility(ability);
	}
	
	/* -------------------- MID LEVEL OPERATIONS -------------------- */
	public void insert(SackboundItem item){
		inventoryOwnership.addItem(item);
	}
	
	public void remove(SackboundItem item){
		inventoryOwnership.removeItem(item);
	}
	
	public boolean canSee(Entity spectator){
		return detectionMechanism.canSee(spectator);
	}
	
	
	/* -------------------- IMPLEMENTATIONS -------------------- */
	public Entity getDerivedClass() {
		return this;
	}

	public void accept(StatsVisitor visitor){
		statsOwnership.accept(visitor);
	}

	public void accept(Effect effect) {
		effect.performEffect(this);
	}
	
	public void remember(VisibleMap m){
		memory.remember(m);
	}
	
	/* -------------------- OVERENCUMBERED GARBAGE -------------------- */
	public int[][] getBrightnessTable(){
		int xSize = ((GameMap) (GameWorld.getCurrentMap())) .getTiles().length;
		int ySize = ((GameMap) (GameWorld.getCurrentMap())) .getTiles()[0].length;
		int[][] btable = new int[xSize][ySize];
		//fill out 0 brightness
		for(int i = 0; i != xSize; ++i){
			for(int j = 0; j != ySize; ++j){
				btable[i][j] = 100;
			}
		}
		//fill out full brightness
		List<Coordinate2D> fullCoords = sight.getCoordinates();
		for(Coordinate2D c : fullCoords){
			btable[c.getX()][c.getY()] = 0;
		}
		//fill out half brightness
		List<Coordinate2D> halfCoords = sight.getCoordinates();
		for(Coordinate2D c : halfCoords){
			btable[c.getX()][c.getY()] = 50;
		}
		return btable;
	}
	
	public List<MapObject> getVisibleMapObjects(){
		List<MapObject> mtable = new ArrayList<MapObject>();
		List<List<MapObject>> visibleMapObjects = sight.getMapObjects();
		List<List<MapObject>> memMapObjects = memory.getMapObjects();
		for(List<MapObject> l : visibleMapObjects){
			for(MapObject m : l){
			mtable.add(m);
			}
		}
		for(List<MapObject> l : memMapObjects){
			for(MapObject m : l){
				mtable.add(m);
			}
		}
		return mtable;
		
		
		
		
	}
}
