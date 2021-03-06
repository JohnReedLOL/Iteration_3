package model.effect.statseffect;

import model.entity.stats.Stats;

public class DebuffMovement extends StatsEffect{
	public DebuffMovement(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.debuffMovement(getMagnitude());
	}
}
