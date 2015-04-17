package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class BuffRangedWeapon extends SneakStatsEffect {
	public BuffRangedWeapon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.buffRangedWeapon(getMagnitude());
	}
}
