package model.effect.statseffect;

import model.entity.stats.Stats;

public class BuffHardiness extends StatsEffect{
	public BuffHardiness(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.buffHardiness(getMagnitude());
	}
}
