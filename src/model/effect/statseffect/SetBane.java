package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class SetBane extends SummonerStatsEffect {
	public SetBane(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.setBane(getMagnitude());
	}
}
