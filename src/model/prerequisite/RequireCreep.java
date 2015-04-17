package model.prerequisite;

import model.entity.stats.SneakStats;

public class RequireCreep extends SneakStatsPrerequisite{
	RequireCreep(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		if(stats.getCreep() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
