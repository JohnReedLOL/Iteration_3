package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class SetStaff extends SummonerStatsEffect {
	public SetStaff(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.setStaff(getMagnitude());
	}
}
