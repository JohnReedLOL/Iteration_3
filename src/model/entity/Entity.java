package model.entity;

import model.armory.ArmoryOwnership;
import model.entity.stats.StatsVisitor;
import model.inventory.InventoryOwnership;
import model.item.sackbound.equip.EquipItem;

public class Entity {
	// TODO: Most of it.

	/**
	 * PROPERTIES
	 */

	private ArmoryOwnership armoryOwnership;
	private InventoryOwnership inventoryOwnership;

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

	/**
	 * IMPLEMENTATIONS
	 */

	public void accept(StatsVisitor visitor){
		// TODO
	}
}
