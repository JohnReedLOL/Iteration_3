package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class DebuffCreep extends SneakStatsEffect {
	public DebuffCreep(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.debuffCreep(getMagnitude());
	}
}
