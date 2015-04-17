package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetIntellect extends StatsEffect{
	public SetIntellect(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setIntellect(getMagnitude());
	}
}
