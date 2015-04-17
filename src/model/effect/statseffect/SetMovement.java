package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetMovement extends StatsEffect{
	public SetMovement(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setMovement(getMagnitude());
	}
}
