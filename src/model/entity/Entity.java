package model.entity;


import model.MapObject;
import model.armory.Armory;
import model.armory.ArmoryOwnership;
import model.effect.Effect;
import model.entity.behavior.combat.CombatBehavior;
import model.entity.behavior.movement.MovementBehavior;
import model.entity.detection.Detection;
import model.entity.occupation.Occupation;
import model.entity.stats.StatsVisitor;
import model.inventory.InventoryOwnership;
import model.inventory.Sack;

public abstract class Entity extends MapObject {
	// TODO: Most of it.

	/**
	 * PROPERTIES
	 */

	private ArmoryOwnership armoryOwnership;
	private InventoryOwnership inventoryOwnership;
	private Detection detectionMechanism;
	private Occupation occupation;
	private MovementBehavior movementBehavior;
	private CombatBehavior combatBehavior;

	/**
	 * CONSTRUCTORS
	 */
        
	public Entity(Armory armory, Sack sack, Occupation occupation, MovementBehavior movementBehavior) {
		this("Entity", "Entity Desc", armory, sack, occupation, movementBehavior);
	}

	public Entity(String name, String description, Armory armory, Sack sack, Occupation occupation,
				  MovementBehavior movementBehavior) {
		super(name, description);

		this.armoryOwnership = new ArmoryOwnership(this, armory);
		this.inventoryOwnership = new InventoryOwnership(this, sack, 10);
		this.detectionMechanism = new Detection();
		this.occupation = occupation;
		this.movementBehavior = movementBehavior;
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

	public Occupation getOccupation() {
		return this.occupation;
	}

	public MovementBehavior getMovementBehavior() {
		return this.movementBehavior;
	}

	/**
	 * MUTATORS
	 */

	public void setDetectionMechanism(Detection detection) {
		this.detectionMechanism = detection;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public void setMovementBehavior(MovementBehavior movement) {
		this.movementBehavior = movement;
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
}
