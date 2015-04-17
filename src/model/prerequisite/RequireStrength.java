package model.prerequisite;

import model.entity.stats.Stats;

public class RequireStrength extends StatsPrerequisite{
	RequireStrength(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getStrength() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
