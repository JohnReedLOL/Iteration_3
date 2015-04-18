package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetObservation extends StatsEffect{
	public SetObservation(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setObservation(getMagnitude());
	}
}
