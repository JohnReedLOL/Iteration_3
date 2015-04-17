package model.effect.statseffect;

import model.entity.stats.Stats;

public class DebuffAgility extends StatsEffect{
	public DebuffAgility(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.debuffAgility(getMagnitude());
	}
}
