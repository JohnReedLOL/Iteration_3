package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyBindWounds extends StatsEffect{
	public ModifyBindWounds(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyBindWounds(getMagnitude());
	}
}
