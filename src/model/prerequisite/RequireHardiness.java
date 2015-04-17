package model.prerequisite;

import model.entity.stats.Stats;

public class RequireHardiness extends StatsPrerequisite{
	RequireHardiness(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getHardiness() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
