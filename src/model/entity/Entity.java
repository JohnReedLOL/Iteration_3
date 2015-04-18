package model.entity;


import model.MapObject;
import model.armory.Armory;
import model.armory.ArmoryOwnership;
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

	/**
	 * CONSTRUCTORS
	 */
        
	public Entity(Armory armory, Sack sack, Occupation occupation) {
		this("Entity", "Entity Desc", armory, sack, occupation);
	}

	public Entity(String name, String description, Armory armory, Sack sack, Occupation occupation) {
		super(name, description);

		this.armoryOwnership = new ArmoryOwnership(this, armory);
		this.inventoryOwnership = new InventoryOwnership(this, sack, 10);
		this.detectionMechanism = new Detection();
		this.occupation = occupation;
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

	/**
	 * MUTATORS
	 */

	public void setDetectionMechanism(Detection detection) {
		this.detectionMechanism = detection;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
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
}
