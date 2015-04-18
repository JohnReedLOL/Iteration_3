package model.item.sackbound;

import model.effect.Effect;
import model.entity.Entity;
import model.item.Item;
import model.prerequisite.Prerequisite;

import java.util.ArrayList;

public abstract class SackboundItem extends Item {
    /**
     * PROPERTIES
     */

    private ArrayList<Prerequisite> pickUpPrerequisites = null;
    private ArrayList<Effect> pickUpEffects = null;

    /**
     * CONSTRUCTORS
     */

    public SackboundItem() {
        this("SackboundItem", "Sackbound Desc");
    }

    public SackboundItem(String name, String description) {
        super(name, description);

        this.pickUpPrerequisites = new ArrayList<Prerequisite>();
        this.pickUpEffects = new ArrayList<Effect>();
    }

    /**
     * GETTERS
     */

    public ArrayList<Prerequisite> getPickUpPrerequisites() {
        return this.pickUpPrerequisites;
    }

    public ArrayList<Effect> getPickUpEffects() {
        return this.pickUpEffects;
    }

    /**
     * MUTATORS
     */

    public void addPickUpPrerequisite(Prerequisite prereq) {
        getPickUpPrerequisites().add(prereq);
    }

    public void removePickUpPrerequisite(Prerequisite prereq) {
        getPickUpPrerequisites().remove(prereq);
    }

    public void addPickUpEffect(Effect effect) {
        getPickUpEffects().add(effect);
    }

    public void removePickUpEffect(Effect effect) {
        getPickUpEffects().remove(effect);
    }

    /**]
     * IMPLEMENTATIONS
     */

    @Override
    public SackboundItem getDerivedClass() {
        return this;
    }

    @Override
    public boolean activateOnMap(Entity activator) {
        if (!meetsPickUpRequirements(activator)) {
            return false;
        }

        return activator.getInventoryOwnership().addItem(this);
    }

    protected boolean meetsPickUpRequirements(Entity target) {
        for (Prerequisite req : getPickUpPrerequisites()) {
            if (!req.meetsRequirement(target)) {
                return false;
            }
        }

        return true;
    }
}
