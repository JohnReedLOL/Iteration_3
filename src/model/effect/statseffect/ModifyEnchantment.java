package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class ModifyEnchantment extends SummonerStatsEffect {
	public ModifyEnchantment(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.modifyEnchantment(getMagnitude());
	}
}
