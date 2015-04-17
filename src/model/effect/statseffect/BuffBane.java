package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class BuffBane extends SummonerStatsEffect {
	public BuffBane(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.buffBane(getMagnitude());
	}
}
