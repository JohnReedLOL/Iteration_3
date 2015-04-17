package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyHardiness extends StatsEffect{
	public ModifyHardiness(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyHardiness(getMagnitude());
	}
}
