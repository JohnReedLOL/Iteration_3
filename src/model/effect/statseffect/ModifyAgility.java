package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyAgility extends StatsEffect{
	public ModifyAgility(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyAgility(getMagnitude());
	}
}
