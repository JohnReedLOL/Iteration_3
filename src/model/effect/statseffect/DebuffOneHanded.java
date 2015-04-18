package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class DebuffOneHanded extends SmasherStatsEffect {
	public DebuffOneHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.debuffOneHanded(getMagnitude());
	}
}
