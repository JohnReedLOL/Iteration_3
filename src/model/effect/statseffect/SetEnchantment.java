package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class SetEnchantment extends SummonerStatsEffect {
	public SetEnchantment(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.setEnchantment(getMagnitude());
	}
}
