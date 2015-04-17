package model.prerequisite;

import model.entity.stats.SmasherStats;

public class RequireTwoHanded extends SmasherStatsPrerequisite{
	RequireTwoHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		if(stats.getTwoHanded() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
