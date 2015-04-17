package model.item.sackbound;

import model.effect.Effect;
import model.entity.Entity;
import model.item.Item;
import model.prerequisite.Prerequisite;

import java.util.ArrayList;

public class SackboundItem extends Item {
    /**
     * PROPERTIES
     */

    private ArrayList<Prerequisite> pickUpPrerequisites = null;
    private ArrayList<Effect> pickUpEffects = null;

    /**
     * CONSTRUCTORS
     */

    public SackboundItem() {
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

    public void addPrerequisite(Prerequisite prereq) {
        getPickUpPrerequisites().add(prereq);
    }

    public void removePrerequisite(Prerequisite prereq) {
        getPickUpPrerequisites().remove(prereq);
    }

    public void addPickUpEffect(Effect effect) {
        getPickUpEffects().add(effect);
    }

    public void removePickUpEffect(Effect effect) {
        getPickUpEffects().remove(effect);
    }

    public boolean activateOnMap(Entity activator) {
        // TODO
        return false;
    }
}
