package model.item.interactive;

import model.effect.Effect;
import model.entity.Entity;
import model.item.Item;
import model.prerequisite.Prerequisite;

import java.util.ArrayList;

public class InteractiveItem implements Item {
    /**
     * PROPERTIES
     */

    private ArrayList<Prerequisite> activationRequirements;
    private ArrayList<Effect> activationEffects;
    private boolean hasActivated;

    /**
     * CONSTRUCTORS
     */

    public InteractiveItem() {
        super();

        this.activationRequirements = new ArrayList<Prerequisite>();
        this.activationEffects = new ArrayList<Effect>();
        this.hasActivated = false;
    }

    /**
     * GETTERS
     */

    public ArrayList<Prerequisite> getActivationRequirements() {
        return activationRequirements;
    }

    public ArrayList<Effect> getActivationEffects() {
        return activationEffects;
    }

    public boolean getHasActivated() {
        return this.hasActivated;
    }

    /**
     * MUTATORS
     */

    public void setHasActivated(boolean activated) {
        this.hasActivated = activated;
    }

    public void setActivationRequirements(ArrayList<Prerequisite> activationRequirements) {
        this.activationRequirements = activationRequirements;
    }

    public void setActivationEffects(ArrayList<Effect> activationEffects) {
        this.activationEffects = activationEffects;
    }

    public void addActivationEffect(Effect effect) {
        this.activationEffects.add(effect);
    }

    public void removeActivationEffect(Effect effect) {
        this.activationEffects.remove(effect);
    }

    public void addActivationRequirements(Prerequisite prereq) {
        this.activationRequirements.add(prereq);
    }

    public void removeActivationRequirement(Prerequisite prereq) {
        this.activationRequirements.remove(prereq);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public boolean activateOnMap(Entity activator) {
        if (!getHasActivated()) {
            if (!checkActivationRequirements(activator)) {
                return false;
            }

            applyActivationEffects(activator);
            setHasActivated(true);
        }

        return hasActivated;
    }

    protected void applyActivationEffects(Entity target) {
        for (Effect effect : getActivationEffects()) {
            effect.affect(target);
        }
    }

    protected boolean checkActivationRequirements(Entity target) {
        for (Prerequisite prereq : getActivationRequirements()) {
            if (!prereq.meetsRequirement(target)) {
                return false;
            }
        }

        return true;
    }
}
