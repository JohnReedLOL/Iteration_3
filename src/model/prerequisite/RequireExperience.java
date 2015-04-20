package model.prerequisite;

import model.entity.stats.Stats;

public class RequireExperience extends StatsPrerequisite{
	public RequireExperience(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getExperience() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
