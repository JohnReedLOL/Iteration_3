package model.item.interactive;

import model.effect.Effect;
import model.entity.Entity;
import model.item.Item;
import model.prerequisite.Prerequisite;

import java.util.ArrayList;

public class InteractiveItem extends Item {
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
        this("InteractiveItem", "Interactive Item Desc");
    }

    public InteractiveItem(String name, String description) {
        super(name, description);

        this.activationRequirements = new ArrayList<Prerequisite>();
        this.activationEffects = new ArrayList<Effect>();
        this.hasActivated = false;
    }

    /**
     * GETTERS
     */

    public ArrayList<Prerequisite> getActivationRequirements() {
        return this.activationRequirements;
    }

    public ArrayList<Effect> getActivationEffects() {
        return this.activationEffects;
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
        getActivationEffects().add(effect);
    }

    public void removeActivationEffect(Effect effect) {
        getActivationEffects().remove(effect);
    }

    public void addActivationRequirement(Prerequisite prereq) {
        getActivationRequirements().add(prereq);
    }

    public void removeActivationRequirement(Prerequisite prereq) {
        getActivationRequirements().remove(prereq);
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

        return getHasActivated();
    }

    protected void applyActivationEffects(Entity target) {
        for (Effect effect : getActivationEffects()) {
            effect.performEffect(target);
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
