package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class SetRangedWeapon extends SneakStatsEffect {
	public SetRangedWeapon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.setRangedWeapon(getMagnitude());
	}
}
