package model.armory;

import model.item.sackbound.equip.EquipItem;

import java.util.ArrayList;

public class Armory {
    /**
     * PROPERTIES
     */

    private ArrayList<EquipItem> contents;
    private static final int MAX_CAPACITY = 5;

    /**
     * CONSTRUCTORS
     */

    public Armory() {
        this.contents = new ArrayList<EquipItem>();
        for (int i = 0; i < MAX_CAPACITY; ++i) {
        	contents.add(null);
        }
    }

    /**
     * GETTERS
     */

    public ArrayList<EquipItem> getContents() {
        return this.contents;
    }

    public int getSize() {
        return getContents().size();
    }

    public int getCapacity() {
        return MAX_CAPACITY;
    }

    public EquipItem getItemAtSlot(EquipItem.EquipSlot slot) {
        return getContents().get(slot.getSlot());
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

    public boolean containsItem(EquipItem item) {
        return getContents().contains(item);
    }

    private EquipItem removeItem(EquipItem item) {
        return removeItem(item.getEquipSlot());
    }

    private EquipItem removeItem(EquipItem.EquipSlot slot) {
        return getContents().remove(slot.getSlot());
    }

    private void setItem(EquipItem item) {
        EquipItem.EquipSlot slot = item.getEquipSlot();
        getContents().set(slot.getSlot(), item);
    }
}
