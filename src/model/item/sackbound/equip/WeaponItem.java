package model.item.sackbound.equip;

import model.effect.Effect;
import model.entity.Entity;

import java.util.ArrayList;

public class WeaponItem extends EquipItem {
    /**
     * PROPERTIES
     */

    private ArrayList<Effect> attackEffects;

    /**
     * CONSTRUCTORS
     */

    public WeaponItem(EquipSlot slot) {
        super(slot);

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
        this.attackEffects.add(effect);
    }

    public void removeAttackEffect(Effect effect) {
        this.attackEffects.remove(effect);
    }

    /**
     * IMPLEMENTATIONS
     */

    public void attack(Entity user) {
        // TODO: Once Entity has all of its functionality.
    }
}
