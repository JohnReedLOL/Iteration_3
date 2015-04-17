package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class BuffStaff extends SummonerStatsEffect {
	public BuffStaff(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.buffStaff(getMagnitude());
	}
}
