package model.prerequisite;

import model.entity.stats.Stats;

public class RequireOffense extends StatsPrerequisite{
	RequireOffense(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getOffense() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
