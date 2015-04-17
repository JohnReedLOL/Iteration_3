package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class DebuffStaff extends SummonerStatsEffect {
	public DebuffStaff(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.debuffStaff(getMagnitude());
	}
}
