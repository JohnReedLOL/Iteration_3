package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class ModifyPickpocket extends SneakStatsEffect {
	public ModifyPickpocket(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.modifyPickpocket(getMagnitude());
	}
}
