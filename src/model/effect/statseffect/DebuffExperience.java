package model.effect.statseffect;

import model.entity.stats.Stats;

public class DebuffExperience extends StatsEffect{
	public DebuffExperience(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.debuffExperience(getMagnitude());
	}
}
