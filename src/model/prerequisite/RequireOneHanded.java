package model.prerequisite;

import model.entity.stats.SmasherStats;

public class RequireOneHanded extends SmasherStatsPrerequisite{
	RequireOneHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		if(stats.getOneHanded() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
