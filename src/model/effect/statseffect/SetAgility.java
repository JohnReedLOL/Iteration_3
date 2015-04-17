package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetAgility extends StatsEffect{
	public SetAgility(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setAgility(getMagnitude());
	}
}
