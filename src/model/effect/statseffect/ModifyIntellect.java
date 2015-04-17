package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyIntellect extends StatsEffect{
	public ModifyIntellect(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyIntellect(getMagnitude());
	}
}
