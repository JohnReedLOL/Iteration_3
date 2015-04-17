package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetCurrentLife extends StatsEffect{
	public SetCurrentLife(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setCurrentLife(getMagnitude());
	}
}
