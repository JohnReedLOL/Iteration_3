package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class DebuffBane extends SummonerStatsEffect {
	public DebuffBane(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.debuffBane(getMagnitude());
	}
}
