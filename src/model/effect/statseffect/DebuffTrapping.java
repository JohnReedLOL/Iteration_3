package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class DebuffTrapping extends SneakStatsEffect {
	public DebuffTrapping(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.debuffTrapping(getMagnitude());
	}
}
