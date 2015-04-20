package model.prerequisite;

import model.entity.stats.SummonerStats;

public class RequireStaff extends SummonerStatsPrerequisite{
	public RequireStaff(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		if(stats.getStaff() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
