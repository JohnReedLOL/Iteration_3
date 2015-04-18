package model.entity;


import model.MapObject;
import model.armory.ArmoryOwnership;
import model.entity.detection.Detection;
import model.entity.stats.StatsVisitor;
import model.inventory.InventoryOwnership;
import model.item.sackbound.SackboundItem;
import model.item.sackbound.equip.EquipItem;
import model.map.location.Location;

public class Entity extends MapObject {
	// TODO: Most of it.

	/**
	 * PROPERTIES
	 */

	private ArmoryOwnership armoryOwnership;
	private InventoryOwnership inventoryOwnership;
	private Detection detectionMechanism;

	/**
	 * CONSTRUCTORS
	 */

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

	/**
	 * MUTATORS
	 */

	public void setDetectionMechanism(Detection detection) {
		this.detectionMechanism = detection;
	}

	/**
	 * IMPLEMENTATIONS
	 */

	public void accept(StatsVisitor visitor){
		// TODO
	}
	public void createAssociation(Location location){
		//TODO
	}
}
