package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class BuffCreep extends SneakStatsEffect {
	public BuffCreep(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.buffCreep(getMagnitude());
	}
}
