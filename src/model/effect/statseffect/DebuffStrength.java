package model.effect.statseffect;

import model.entity.stats.Stats;

public class DebuffStrength extends StatsEffect{
	public DebuffStrength(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.debuffStrength(getMagnitude());
	}
}
