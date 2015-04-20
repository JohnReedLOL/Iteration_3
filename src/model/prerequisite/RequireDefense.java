package model.prerequisite;

import model.entity.stats.Stats;

public class RequireDefense extends StatsPrerequisite{
	public RequireDefense(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getDefense() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
