package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class BuffOneHanded extends SmasherStatsEffect {
	public BuffOneHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.buffOneHanded(getMagnitude());
	}
}
