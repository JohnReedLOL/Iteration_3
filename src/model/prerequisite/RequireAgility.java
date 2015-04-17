package model.prerequisite;

import model.entity.stats.Stats;

public class RequireAgility extends StatsPrerequisite{
	RequireAgility(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getAgility() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
