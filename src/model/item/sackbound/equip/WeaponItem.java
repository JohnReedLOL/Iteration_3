package model.item.sackbound.equip;

import java.util.ArrayList;
import java.util.Collection;

import model.effect.Effect;
import model.entity.Entity;
import model.influence_set.InfluenceSet;
import model.map.GameWorld;
import view.utility.ObjectRenderer;

public class WeaponItem extends EquipItem {
    /**
     * PROPERTIES
     */

    private ArrayList<Effect> attackEffects;
    private Collection<InfluenceSet> affectedAreas;

    /**
     * CONSTRUCTORS
     */

    public WeaponItem(String name, String descrption, EquipSlot slot, Collection<InfluenceSet> set) {
        super(name, descrption, slot);

        this.attackEffects = new ArrayList<Effect>();
        this.affectedAreas = set;
    }

    /**
     * GETTERS
     */

    public ArrayList<Effect> getAttackEffects() {
        return this.attackEffects;
    }

    public Collection<InfluenceSet> getAffectedAreas() {
        return this.affectedAreas;
    }

    /**
     * MUTATORS
     */

    public void setAttackEffects(ArrayList<Effect> effects) {
        this.attackEffects = effects;
    }

    public void setAffectedAreas(Collection<InfluenceSet> affectedAreas) {
        this.affectedAreas = affectedAreas;
    }

    public void addAttackEffect(Effect effect) {
        getAttackEffects().add(effect);
    }

    public void removeAttackEffect(Effect effect) {
        getAttackEffects().remove(effect);
    }

    public void addInfluenceSet(InfluenceSet set) {
        getAffectedAreas().add(set);
    }

    public void removeInfluenceSet(InfluenceSet set) {
        getAffectedAreas().remove(set);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public WeaponItem getDerivedClass() {
        return this;
    }

    public void attack(Entity user) {
        for(InfluenceSet i : affectedAreas){
        	i.setSourceLocation(GameWorld.getCurrentMap().getLocationByMapObject(user));
        	for(Effect e : attackEffects){
        		GameWorld.getCurrentMap().performEffect(e,i);
        	}
        }
    }
    
    @Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}
}
