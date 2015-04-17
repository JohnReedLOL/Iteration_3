package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetExperience extends StatsEffect{
	public SetExperience(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setExperience(getMagnitude());
	}
}
