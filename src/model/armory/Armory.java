package model.armory;

import model.item.sackbound.equip.EquipItem;

import java.util.ArrayList;

public class Armory {
    /**
     * PROPERTIES
     */

    private ArrayList<EquipItem> equipment;
    private static final int MAX_CAPACITY = 5;

    /**
     * CONSTRUCTORS
     */

    public Armory() {
        this.equipment = new ArrayList<EquipItem>();
    }

    /**
     * GETTERS
     */

    public ArrayList<EquipItem> getEquipment() {
        return this.equipment;
    }

    public int getSize() {
        return getEquipment().size();
    }

    public int getCapacity() {
        return MAX_CAPACITY;
    }

    /**
     * MUTATORS
     */

    public EquipItem equip(EquipItem item) {
        EquipItem equipped = unequip(item.getEquipSlot());
        setItem(item);

        return equipped;
    }

    public EquipItem unequip(EquipItem item) {
        return removeItem(item);
    }

    public EquipItem unequip(EquipItem.EquipSlot slot) {
        return removeItem(slot);
    }

    /**
     * IMPLEMENTATIONS
     */

    private EquipItem removeItem(EquipItem item) {
        return removeItem(item.getEquipSlot());
    }

    private EquipItem removeItem(EquipItem.EquipSlot slot) {
        return getEquipment().remove(slot.getSlot());
    }

    private void setItem(EquipItem item) {
        EquipItem.EquipSlot slot = item.getEquipSlot();
        getEquipment().set(slot.getSlot(), item);
    }
}
