package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyCurrentLife extends StatsEffect{
	public ModifyCurrentLife(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyCurrentLife(getMagnitude());
	}
}
