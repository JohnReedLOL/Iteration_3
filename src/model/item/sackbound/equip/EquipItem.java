package model.item.sackbound.equip;

import model.effect.Effect;
import model.entity.Entity;
import model.item.sackbound.SackboundItem;
import model.prerequisite.Prerequisite;

import java.util.ArrayList;

public class EquipItem extends SackboundItem {
    private ArrayList<Effect> equipEffects;
    private ArrayList<Prerequisite> equipPrerequisites;
    private EquipSlot slot;

    public EquipItem(EquipSlot slot) {
        super();

        this.equipEffects = new ArrayList<Effect>();
        this.equipPrerequisites = new ArrayList<Prerequisite>();
        this.slot = slot;
    }

    /**
     * GETTERS
     */

    public int getSlot() {
        return slot.getSlot();
    }

    public ArrayList<Effect> getEquipEffects() {
        return this.equipEffects;
    }

    public ArrayList<Prerequisite> getEquipPrerequisite() {
        return this.equipPrerequisites;
    }

    /**
     * MUTATORS
     */

    public void addEquipEffect(Effect effect) {
        this.equipEffects.add(effect);
    }

    public void addEquipPrerequisite(Prerequisite prereq) {
        this.equipPrerequisites.add(prereq);
    }

    public void removeEquipEffect(Effect effect) {
        this.equipEffects.remove(effect);
    }

    public void removeEquipPrerequisite(Prerequisite prereq) {
        this.equipPrerequisites.remove(prereq);
    }

    public void setEquipEffects(ArrayList<Effect> effects) {
        this.equipEffects = effects;
    }

    public void setEquipPrerequisites(ArrayList<Prerequisite> prereqs) {
        this.equipPrerequisites = prereqs;
    }

    public boolean equip(Entity user) {
        // TODO: Once Entity has all of its functionality.
        return false;
    }

    public void unequip(Entity user) {
        // TODO: One Entity has all of its functionality.
    }

    /**
     * INNER-CLASS: EQUIPSLOT
     */

    public enum EquipSlot {
        HEAD,
        MAINHAND,
        OFFHAND,
        TORSO,
        LEGS;

        protected int getSlot() {
            return ordinal();
        }
    }
}
