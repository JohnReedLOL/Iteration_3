package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyObservation extends StatsEffect{
	public ModifyObservation(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyObservation(getMagnitude());
	}
}
