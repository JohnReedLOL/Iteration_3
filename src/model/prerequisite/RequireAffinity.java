package model.prerequisite;

import model.entity.stats.Stats;

public class RequireAffinity extends StatsPrerequisite{
	public RequireAffinity(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getAffinity() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
