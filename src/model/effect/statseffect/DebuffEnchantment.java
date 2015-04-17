package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class DebuffEnchantment extends SummonerStatsEffect {
	public DebuffEnchantment(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.debuffEnchantment(getMagnitude());
	}
}
