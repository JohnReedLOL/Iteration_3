package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class SetBrawl extends SmasherStatsEffect {
	public SetBrawl(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.setBrawl(getMagnitude());
	}
}
