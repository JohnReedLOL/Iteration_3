package model.item.oneshot;

import model.effect.Effect;
import model.entity.Entity;
import model.item.Item;

import java.util.ArrayList;

public class OneShotItem extends Item {
    /**
     *  PROPERTIES
     */

    private ArrayList<Effect> activationEffects;

    /**
     * CONSTRUCTORS
     */

    public OneShotItem() {
        this("OneShotItem", "OneShot Desc");
    }

    public OneShotItem(String name, String description) {
        super(name, description);

        this.activationEffects = new ArrayList<Effect>();
    }

    /**
     * GETTERS
     */

    public ArrayList<Effect> getActivationEffects() {
        return this.activationEffects;
    }

    /**
     * MUTATORS
     */

    public void setActivationEffects(ArrayList<Effect> effects) {
        this.activationEffects = effects;
    }

    public void addActivationEffect(Effect effect) {
        getActivationEffects().add(effect);
    }

    public void removeActivationEffect(Effect effect) {
        getActivationEffects().remove(effect);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void apply(Entity target) {
        applyActivationEffects(target);
    }

    @Override
    public boolean activateOnMap(Entity activator) {
        return true;
    }

    protected void applyActivationEffects(Entity target) {
        for (Effect effect : getActivationEffects()) {
            effect.performEffect(target);
        }
    }
}
