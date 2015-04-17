package model.prerequisite;

import model.entity.stats.Stats;

public class RequireLevel extends StatsPrerequisite{
	RequireLevel(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getLevel() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
