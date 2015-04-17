package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class ModifyTrapping extends SneakStatsEffect {
	public ModifyTrapping(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.modifyTrapping(getMagnitude());
	}
}
