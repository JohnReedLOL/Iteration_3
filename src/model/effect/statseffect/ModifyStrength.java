package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyStrength extends StatsEffect{
	public ModifyStrength(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyStrength(getMagnitude());
	}
}
