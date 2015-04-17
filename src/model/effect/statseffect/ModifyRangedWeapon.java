package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class ModifyRangedWeapon extends SneakStatsEffect {
	public ModifyRangedWeapon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.modifyRangedWeapon(getMagnitude());
	}
}
