package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class ModifyCreep extends SneakStatsEffect {
	public ModifyCreep(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.modifyCreep(getMagnitude());
	}
}
