package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class SetPickpocket extends SneakStatsEffect {
	public SetPickpocket(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.setPickpocket(getMagnitude());
	}
}
