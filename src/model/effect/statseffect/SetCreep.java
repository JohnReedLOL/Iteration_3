package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class SetCreep extends SneakStatsEffect {
	public SetCreep(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.setCreep(getMagnitude());
	}
}
