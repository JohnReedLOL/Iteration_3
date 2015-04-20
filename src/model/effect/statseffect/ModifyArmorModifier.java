package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyArmorModifier extends StatsEffect{
	public ModifyArmorModifier(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyArmorModifier(getMagnitude());
	}
}
