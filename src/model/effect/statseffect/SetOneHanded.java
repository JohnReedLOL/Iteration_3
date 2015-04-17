package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class SetOneHanded extends SmasherStatsEffect {
	public SetOneHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.setOneHanded(getMagnitude());
	}
}
