package model.prerequisite;

import model.entity.stats.Stats;

public class RequireObservation extends StatsPrerequisite{
	public RequireObservation(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getObservation() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
