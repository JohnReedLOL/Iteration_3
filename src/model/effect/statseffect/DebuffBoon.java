package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class DebuffBoon extends SummonerStatsEffect {
	public DebuffBoon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.debuffBoon(getMagnitude());
	}
}
