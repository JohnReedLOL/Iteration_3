package model.item.sackbound.equip;

import java.util.ArrayList;

import model.effect.Effect;
import model.entity.Entity;
import model.item.sackbound.SackboundItem;
import model.prerequisite.Prerequisite;
import view.utility.ObjectRenderer;

public class EquipItem extends SackboundItem {
    private ArrayList<Effect> equipEffects;
    private ArrayList<Effect> unequipEffects;
    private ArrayList<Prerequisite> equipPrerequisites;
    private EquipSlot equipSlot;

    public EquipItem(EquipSlot equipSlot) {
        this("EquipItem", "Equip Desc", equipSlot);
    }

    public EquipItem(String name, String description, EquipSlot equipSlot) {
        super(name, description);

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

    public EquipItem unequip(Entity equipper) {
        if (willSackOverflow(equipper, this.getEquipSlot())) {
            return null;
        }

        return equipper.getArmoryOwnership().unequip(this);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public EquipItem getDerivedClass() {
        return this;
    }

    @Override
    public void apply(Entity target) {
        boolean alreadyEquipped = isWearing(target, this);

        if (!alreadyEquipped) {
            EquipmentPair equip = equipItem(target, this, getEquipSlot());

            if (equip.success) {
                for (EquipItem item : equip.equipItems) {
                    if (item != null) {
                        target.getInventoryOwnership().addItem(item);
                    }
                }
            }
        }
        else {
            EquipItem item = unequip(target);

            if (item != null) {
                target.getInventoryOwnership().addItem(item);
            }
        }
    }

    protected boolean meetsEquipRequirements(Entity equipper, EquipItem toEquip) {
        for (Prerequisite prereq : toEquip.getEquipPrerequisites()) {
            if (!prereq.meetsRequirement(equipper)) {
                return false;
            }
        }

        return true;
    }

    protected EquipmentPair equipItem(Entity equipper, EquipItem item, EquipSlot... slots) {
        // Doesn't meet requirements.
        if (!meetsEquipRequirements(equipper, this)) {
            return new EquipmentPair(null, false);
        }
        // The number of items that need to be un-equipped exceed the capacity of the inventory.
        if (willSackOverflow(equipper, slots)) { // <== LOL
            return new EquipmentPair(null, false);
        }

        ArrayList<EquipItem> equippedItems = new ArrayList<EquipItem>();

        // Un-equip necessary equipped Items.
        for (EquipSlot slot : slots) {
            equippedItems.add(equipper.getArmoryOwnership().unequip(slot));
        }

        equipper.getArmoryOwnership().equip(item);
        return new EquipmentPair(equippedItems, true);
    }

    private int getFilledSlotCount(Entity equipper, EquipSlot... slots) {
        int count = 0;

        for (EquipSlot slot : slots) {
            if (isSlotFilled(equipper, slot)) {
                ++count;
            }
        }

        return count;
    }

    private boolean isSlotFilled(Entity equipper, EquipSlot slot) {
        boolean result = (equipper.getArmoryOwnership().getItemAtSlot(slot) != null);

        return result;
    }

    private boolean willSackOverflow(Entity equipper, EquipSlot... slots) {
        int potentialSize = getFilledSlotCount(equipper, slots);
        potentialSize += equipper.getInventoryOwnership().getSize();

        return (potentialSize > equipper.getInventoryOwnership().getPermittedCapacity());
    }

    protected boolean isWearing(Entity target, EquipItem item) {
        return target.getArmoryOwnership().containsEquipItem(item);
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

	@Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}
}
