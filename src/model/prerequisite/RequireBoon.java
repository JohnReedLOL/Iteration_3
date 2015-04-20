package model.prerequisite;

import model.entity.stats.SummonerStats;

public class RequireBoon extends SummonerStatsPrerequisite{
	public RequireBoon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		if(stats.getBoon() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
