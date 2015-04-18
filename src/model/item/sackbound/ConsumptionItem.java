package model.item.sackbound;

import model.effect.Effect;
import model.entity.Entity;
import model.prerequisite.Prerequisite;

import java.util.ArrayList;

public abstract class ConsumptionItem extends SackboundItem {
    /**
     * PROPERTIES
     */

    private ArrayList<Prerequisite> usePrerequisites;
    private ArrayList<Effect> useEffects;

    /**
     * CONSTRUCTORS
     */

    public ConsumptionItem() {
        this("ConsumptionItem", "Consumption Desc");
    }

    public ConsumptionItem(String name, String description) {
        super(name, description);

        this.usePrerequisites = new ArrayList<Prerequisite>();
        this.useEffects = new ArrayList<Effect>();
    }

    /**
     * GETTERS
     */

    public ArrayList<Prerequisite> getUsePrerequisites() {
        return this.usePrerequisites;
    }

    public ArrayList<Effect> getUseEffects() {
        return this.useEffects;
    }

    /**
     * MUTATORS
     */

    public void setUsePrerequisites(ArrayList<Prerequisite> prereqs) {
        this.usePrerequisites = prereqs;
    }

    public void setUseEffects(ArrayList<Effect> effects) {
        this.useEffects = effects;
    }

    public void addUsePrerequisite(Prerequisite prereq) {
        getUsePrerequisites().add(prereq);
    }

    public void removeUsePrerequisite(Prerequisite prereq) {
        getUsePrerequisites().remove(prereq);
    }

    public void addUseEffect(Effect effect) {
        getUseEffects().add(effect);
    }

    public void removeUseEffect(Effect effect) {
        getUseEffects().remove(effect);
    }

    /**
     * ABSTRACT METHODS
     */

    public abstract boolean activateOnMap(Entity activator);
    public abstract boolean use(Entity user);
}
