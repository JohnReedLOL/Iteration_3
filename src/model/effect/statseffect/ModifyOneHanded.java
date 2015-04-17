package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class ModifyOneHanded extends SmasherStatsEffect {
	public ModifyOneHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.modifyOneHanded(getMagnitude());
	}
}
