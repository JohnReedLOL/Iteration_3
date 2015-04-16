package model.item.obstacle;

import model.effect.Effect;
import model.entity.Entity;
import model.item.Item;

import java.util.ArrayList;

public class ObstacleItem extends Item {
    /**
     * PROPERTIES
     */

    private ArrayList<Effect> activationEffects;

    /**
     * CONSTRUCTORS
     */

    public ObstacleItem() {
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
        // TODO
        return false;
    }
}
