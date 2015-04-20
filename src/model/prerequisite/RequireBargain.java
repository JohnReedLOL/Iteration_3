package model.prerequisite;

import model.entity.stats.Stats;

public class RequireBargain extends StatsPrerequisite{
	public RequireBargain(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getBargain() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
