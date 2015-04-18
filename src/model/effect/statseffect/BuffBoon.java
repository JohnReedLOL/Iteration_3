package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class BuffBoon extends SummonerStatsEffect {
	public BuffBoon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.buffBoon(getMagnitude());
	}
}
