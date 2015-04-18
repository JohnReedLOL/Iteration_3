package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class ModifyBane extends SummonerStatsEffect {
	public ModifyBane(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.modifyBane(getMagnitude());
	}
}
