package model.effect.statseffect;

import model.entity.stats.Stats;

public class DebuffHardiness extends StatsEffect{
	public DebuffHardiness(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.debuffHardiness(getMagnitude());
	}
}
