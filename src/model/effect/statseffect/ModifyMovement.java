package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyMovement extends StatsEffect{
	public ModifyMovement(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyMovement(getMagnitude());
	}
}
