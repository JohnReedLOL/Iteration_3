package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetHardiness extends StatsEffect{
	public SetHardiness(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setHardiness(getMagnitude());
	}
}
