package model.entity;

import model.armory.ArmoryOwnership;
import model.entity.stats.StatsVisitor;
import model.item.sackbound.equip.EquipItem;

public class Entity {
	// TODO: Most of it.

	/**
	 * PROPERTIES
	 */

	private ArmoryOwnership armoryOwnership;

	/**
	 * CONSTRUCTORS
	 */

	/**
	 * GETTERS
	 */

	public ArmoryOwnership getArmoryOwnership() {
		return this.armoryOwnership;
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
