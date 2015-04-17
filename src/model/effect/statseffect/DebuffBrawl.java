package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class DebuffBrawl extends SmasherStatsEffect {
	public DebuffBrawl(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.debuffBrawl(getMagnitude());
	}
}
