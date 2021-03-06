package model.effect.statseffect;

import model.entity.stats.SummonerStats;

public class ModifyStaff extends SummonerStatsEffect {
	public ModifyStaff(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		stats.modifyStaff(getMagnitude());
	}
}
