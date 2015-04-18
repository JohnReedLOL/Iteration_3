package model.armory;

import model.entity.Entity;
import model.item.sackbound.equip.EquipItem;

public class ArmoryOwnership {
    /**
     * PROPERTIES
     */

    private Entity owner;
    private Armory equipment;

    /**
     * CONSTRUCTORS
     */

    public ArmoryOwnership(Entity entity, Armory armory) {
        this.owner = entity;
        this.equipment = armory;
    }

    /**
     * GETTERS
     */

    public Entity getOwner() {
        return this.owner;
    }

    public Armory getEquipment() {
        return this.equipment;
    }

    public int getSize() {
        return getEquipment().getSize();
    }

    public int getCapacity() {
        return getEquipment().getCapacity();
    }

    public EquipItem getItemAtSlot(EquipItem.EquipSlot slot) {
        return getEquipment().getItemAtSlot(slot);
    }

    /**
     * MUTATORS
     */

    public EquipItem equip(EquipItem item) {
        return getEquipment().equip(item);
    }

    public EquipItem unequip(EquipItem item) {
        return unequip(item.getEquipSlot());
    }

    public EquipItem unequip(EquipItem.EquipSlot slot) {
        return getEquipment().unequip(slot);
    }

    /**
     * IMPLEMENTATIONS
     */

    public boolean containsEquipItem(EquipItem item) {
        return getEquipment().containsItem(item);
    }
}
