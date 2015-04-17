package model.prerequisite;

import model.entity.stats.Stats;

public class RequireBargain extends StatsPrerequisite{
	RequireBargain(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getBargain() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
