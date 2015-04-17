package model.prerequisite;

import model.entity.stats.SneakStats;

public class RequireTrapping extends SneakStatsPrerequisite{
	RequireTrapping(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		if(stats.getTrapping() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
