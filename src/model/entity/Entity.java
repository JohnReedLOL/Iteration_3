package model.entity;


import model.MapObject;
import model.armory.Armory;
import model.armory.ArmoryOwnership;
import model.effect.Effect;
import model.entity.behavior.movement.MovementBehavior;
import model.entity.detection.Detection;
import model.entity.memory.RememberedMap;
import model.entity.memory.VisibleMap;
import model.entity.stats.StatsOwnership;
import model.entity.stats.StatsVisitor;
import model.inventory.InventoryOwnership;
import model.inventory.Sack;
import model.map.location.Location;
import view.utility.ObjectRenderer;

public abstract class Entity extends MapObject {
	// TODO: Most of it.

	/**
	 * PROPERTIES
	 */

	private ArmoryOwnership armoryOwnership;
	private InventoryOwnership inventoryOwnership;
	private StatsOwnership statsOwnership;
	private Detection detectionMechanism;
	private MovementBehavior movementBehavior;
	private RememberedMap memory;
	private VisibleMap sight;

	/**
	 * CONSTRUCTORS
	 */
        
	public Entity(Armory armory, Sack sack, MovementBehavior movementBehavior, StatsOwnership stats) {
		this("Entity", "Entity Desc", armory, sack, movementBehavior, stats);
	}

	public Entity(String name, String description, Armory armory, Sack sack, MovementBehavior movementBehavior, StatsOwnership stats) {
		super(name, description);

		this.armoryOwnership = new ArmoryOwnership(this, armory);
		this.inventoryOwnership = new InventoryOwnership(this, sack, 10);
		this.statsOwnership = new StatsOwnership(this);
		this.detectionMechanism = new Detection();
		this.movementBehavior = movementBehavior;
		this.memory = new RememberedMap(this);
		this.statsOwnership = stats;
		this.statsOwnership.setOwner(this);
	}

	/**
	 * GETTERS
	 */

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

	/**
	 * MUTATORS
	 */

	public void setDetectionMechanism(Detection detection) {
		this.detectionMechanism = detection;
	}

	public void setMovementBehavior(MovementBehavior movement) {
		this.movementBehavior = movement;
	}

	public void setStatsownership(StatsOwnership ownership) {
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

	/**
	 * IMPLEMENTATIONS
	 */

	@Override
	public Entity getDerivedClass() {
		return this;
	}

	public void accept(StatsVisitor visitor){
		// TODO
	}

	@Override
	public void accept(Effect effect) {
		effect.performEffect(this);
	}
	
	public void remember(VisibleMap m){
		memory.remember(m);
	}
}
