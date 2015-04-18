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

	public EquipItem equipItem(EquipItem item) {
		return getArmoryOwnership().equip(item);
	}

	public EquipItem unequipItem(EquipItem item) {
		return getArmoryOwnership().unequip(item);
	}

	public EquipItem unequipItem(EquipItem.EquipSlot slot) {
		return getArmoryOwnership().unequip(slot);
	}

	public void setDetectionMechanism(Detection detection) {
		this.detectionMechanism = detection;
	}

	public boolean addItemToInventory(SackboundItem item) {
		return getInventoryOwnership().addItem(item);
	}

	public void removeItemFromInventory(SackboundItem item) {
		getInventoryOwnership().removeItem(item);
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
