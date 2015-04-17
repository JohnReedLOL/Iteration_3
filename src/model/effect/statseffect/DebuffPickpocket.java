package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class DebuffPickpocket extends SneakStatsEffect {
	public DebuffPickpocket(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.debuffPickpocket(getMagnitude());
	}
}
