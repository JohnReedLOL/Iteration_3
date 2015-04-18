package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetStrength extends StatsEffect{
	public SetStrength(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setStrength(getMagnitude());
	}
}
