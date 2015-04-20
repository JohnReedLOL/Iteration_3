package model.prerequisite;

import model.entity.stats.Stats;

public class RequireMovement extends StatsPrerequisite{
	public RequireMovement(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getMovement() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
