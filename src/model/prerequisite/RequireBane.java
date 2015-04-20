package model.prerequisite;

import model.entity.stats.SummonerStats;

public class RequireBane extends SummonerStatsPrerequisite{
	public RequireBane(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		if(stats.getBane() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
