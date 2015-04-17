package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class ModifyBoon extends SummonerStatsEffect {
	public ModifyBoon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.modifyBoon(getMagnitude());
	}
}
