package model.prerequisite;

import model.entity.stats.Stats;

public class RequireBindWounds extends StatsPrerequisite{
	RequireBindWounds(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getBindWounds() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
