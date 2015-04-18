package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class DebuffRangedWeapon extends SneakStatsEffect {
	public DebuffRangedWeapon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.debuffRangedWeapon(getMagnitude());
	}
}
