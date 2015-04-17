package model.prerequisite;

import model.entity.stats.Stats;

public class RequireIntellect extends StatsPrerequisite{
	RequireIntellect(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getIntellect() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
