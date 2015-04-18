package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class BuffBrawl extends SmasherStatsEffect {
	public BuffBrawl(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.buffBrawl(getMagnitude());
	}
}
