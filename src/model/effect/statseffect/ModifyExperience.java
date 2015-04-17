package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyExperience extends StatsEffect{
	public ModifyExperience(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyExperience(getMagnitude());
	}
}
