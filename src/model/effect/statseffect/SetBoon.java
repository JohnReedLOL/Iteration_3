package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class SetBoon extends SummonerStatsEffect {
	public SetBoon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.setBoon(getMagnitude());
	}
}
