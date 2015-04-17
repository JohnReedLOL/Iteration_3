package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class SetTrapping extends SneakStatsEffect {
	public SetTrapping(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.setTrapping(getMagnitude());
	}
}
