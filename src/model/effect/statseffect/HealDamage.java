package model.effect.statseffect;

import model.entity.stats.Stats;

public class HealDamage extends StatsEffect{
	public HealDamage(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.healDamage(getMagnitude());
	}
}
