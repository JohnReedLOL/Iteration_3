package model.item.oneshot;

import model.effect.Effect;
import model.entity.Entity;
import model.item.Item;

import java.util.ArrayList;

public class OneShotItem implements Item {
    /**
     *  PROPERTIES
     */

    private ArrayList<Effect> activationEffects;

    /**
     * CONSTRUCTORS
     */

    public OneShotItem() {
        super();

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
        this.activationEffects.add(effect);
    }

    public void removeActivationEffect(Effect effect) {
        this.activationEffects.remove(effect);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public boolean activateOnMap(Entity activator) {
        applyActivationEffects(activator);

        return true;
    }

    protected void applyActivationEffects(Entity target) {
        for (Effect effect : activationEffects) {
            effect.affect(target);
        }
    }
}
