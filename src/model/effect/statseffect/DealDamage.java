package model.effect.statseffect;

import model.entity.stats.Stats;

public class DealDamage extends StatsEffect{
	public DealDamage(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.dealDamage(getMagnitude());
	}
}
