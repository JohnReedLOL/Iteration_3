package model.effect.statseffect;

import model.entity.stats.Stats;

public class BuffObservation extends StatsEffect{
	public BuffObservation(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.buffObservation(getMagnitude());
	}
}
