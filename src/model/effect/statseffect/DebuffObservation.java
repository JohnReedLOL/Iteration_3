package model.effect.statseffect;

import model.entity.stats.Stats;

public class DebuffObservation extends StatsEffect{
	public DebuffObservation(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.debuffObservation(getMagnitude());
	}
}
