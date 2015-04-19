package model.item.sackbound.equip;

import java.util.ArrayList;

import model.effect.Effect;
import model.entity.Entity;
import view.utility.ObjectRenderer;

public class WeaponItem extends EquipItem {
    /**
     * PROPERTIES
     */

    private ArrayList<Effect> attackEffects;

    /**
     * CONSTRUCTORS
     */

    public WeaponItem() {
        this("WeaponItem", "Weapon Desc", EquipSlot.MAINHAND);
    }

    public WeaponItem(String name, String descrption, EquipSlot slot) {
        super(name, descrption, slot);

        this.attackEffects = new ArrayList<Effect>();
    }

    /**
     * GETTERS
     */

    public ArrayList<Effect> getAttackEffects() {
        return this.attackEffects;
    }

    /**
     * MUTATORS
     */

    public void setAttackEffects(ArrayList<Effect> effects) {
        this.attackEffects = effects;
    }

    public void addAttackEffect(Effect effect) {
        getAttackEffects().add(effect);
    }

    public void removeAttackEffect(Effect effect) {
        getAttackEffects().remove(effect);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public WeaponItem getDerivedClass() {
        return this;
    }

    public void attack(Entity user) {
        // TODO: Once Entity has all of its functionality.
    }
    
    @Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}
}
