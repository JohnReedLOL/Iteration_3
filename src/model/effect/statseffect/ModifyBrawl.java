package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class ModifyBrawl extends SmasherStatsEffect {
	public ModifyBrawl(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.modifyBrawl(getMagnitude());
	}
}
