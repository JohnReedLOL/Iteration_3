package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyWeaponModifier extends StatsEffect{
	public ModifyWeaponModifier(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyWeaponModifier(getMagnitude());
	}
}
