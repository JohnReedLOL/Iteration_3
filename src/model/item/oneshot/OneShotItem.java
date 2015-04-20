package model.item.oneshot;

import java.util.ArrayList;

import model.MapObject;
import model.effect.Effect;
import model.entity.Entity;
import model.item.Item;
import model.map.GameWorld;
import view.utility.ObjectRenderer;

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
    public OneShotItem getDerivedClass() {
        return this;
    }

    @Override
    public void apply(Entity target) {
        applyActivationEffects(target);
    }

    @Override
    public boolean activateOnMap(Entity activator) {
        applyActivationEffects(activator);
        GameWorld.getCurrentMap().remove(this);
    	return true;
    }

    protected void applyActivationEffects(Entity target) {
        for (Effect effect : getActivationEffects()) {
            effect.performEffect(target);
        }
    }

	@Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}
	
	public boolean interact(MapObject m){
		return activateOnMap((Entity) m);
	}
}
