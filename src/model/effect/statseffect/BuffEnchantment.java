package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class BuffEnchantment extends SummonerStatsEffect {
	public BuffEnchantment(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.buffEnchantment(getMagnitude());
	}
}
