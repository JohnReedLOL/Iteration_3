package model.item.sackbound.equip;

import model.effect.Effect;
import model.entity.Entity;
import model.item.sackbound.SackboundItem;
import model.prerequisite.Prerequisite;

import java.util.ArrayList;

public class EquipItem extends SackboundItem {
    private ArrayList<Effect> equipEffects;
    private ArrayList<Effect> unequipEffects;
    private ArrayList<Prerequisite> equipPrerequisites;
    private EquipSlot equipSlot;

    public EquipItem(EquipSlot equipSlot) {
        super();

        this.equipEffects = new ArrayList<Effect>();
        this.equipPrerequisites = new ArrayList<Prerequisite>();
        this.equipSlot = equipSlot;
    }

    /**
     * GETTERS
     */

    public EquipSlot getEquipSlot() {
        return this.equipSlot;
    }

    public ArrayList<Effect> getEquipEffects() {
        return this.equipEffects;
    }

    public ArrayList<Effect> getUnequipEffects() {
        return this.unequipEffects;
    }

    public ArrayList<Prerequisite> getEquipPrerequisites() {
        return this.equipPrerequisites;
    }

    /**
     * MUTATORS
     */

    public void addEquipEffect(Effect effect) {
        getEquipEffects().add(effect);
    }

    public void addUnequipEffect(Effect effect) {
        getUnequipEffects().add(effect);
    }

    public void addEquipPrerequisite(Prerequisite prereq) {
        getEquipPrerequisites().add(prereq);
    }

    public void removeEquipEffect(Effect effect) {
        getEquipEffects().remove(effect);
    }

    public void removeUnequipEffect(Effect effect) {
        getUnequipEffects().remove(effect);
    }

    public void removeEquipPrerequisite(Prerequisite prereq) {
        getEquipPrerequisites().remove(prereq);
    }

    public void setEquipEffects(ArrayList<Effect> effects) {
        this.equipEffects = effects;
    }

    public void setUnequipEffects(ArrayList<Effect> effects) {
        this.unequipEffects = effects;
    }

    public void setEquipPrerequisites(ArrayList<Prerequisite> prereqs) {
        this.equipPrerequisites = prereqs;
    }

    // This method will need to overridden the corner case of a Two-Handed Weapon and all of the
    // similar cases that require multiple items to be unequipped for a particular EquipItem
    // to be equip()'d.
    public EquipmentPair equip(Entity user) {
        return equipItem(user, getEquipSlot());
    }

    public EquipmentPair unequip(Entity equipper) {
        // TODO
        return null;
    }

    /**
     * IMPLEMENTATIONS
     */

    protected boolean meetsEquipRequirements(Entity equipper, EquipItem toEquip) {
        for (Prerequisite prereq : toEquip.getEquipPrerequisites()) {
            if (!prereq.meetsRequirement(equipper)) {
                return false;
            }
        }

        return true;
    }

    protected EquipmentPair equipItem(Entity equipper, EquipSlot... slots) {
        // Doesn't meet requirements.
        if (!meetsEquipRequirements(equipper, this)) {
            return new EquipmentPair(null, false);
        }
        // The number of items that need to be un-equipped exceed the capacity of the inventory.
        else if ((slots.length + equipper.getArmoryOwnership().getSize()) > equipper.getArmoryOwnership().getCapacity()) {
            return new EquipmentPair(null, false);
        }

        ArrayList<EquipItem> equippedItems = new ArrayList<EquipItem>();

        // Un-equip necessary equipped Items.
        for (EquipSlot slot : slots) {
            equippedItems.add(equipper.unequipItem(slot));
        }

        equipper.equipItem(this);
        return new EquipmentPair(equippedItems, true);
    }

    /**
     * INNER-CONSTRUCTS
     */

    public enum EquipSlot {
        HEAD,
        MAINHAND,
        OFFHAND,
        TORSO,
        LEGS;

        public int getSlot() {
            return ordinal();
        }
    } // End EquipSlot inner-enum.

    public class EquipmentPair {
        public final ArrayList<EquipItem> equipItems;
        public final boolean success;

        public EquipmentPair(ArrayList<EquipItem> equips, boolean success) {
            this.equipItems = equips;
            this.success = success;
        }
    } // End EquipmentPair inner-class.
}
