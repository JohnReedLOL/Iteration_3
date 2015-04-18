package model.prerequisite;

import model.entity.stats.SneakStats;

public class RequirePickpocket extends SneakStatsPrerequisite{
	RequirePickpocket(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		if(stats.getPickpocket() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
