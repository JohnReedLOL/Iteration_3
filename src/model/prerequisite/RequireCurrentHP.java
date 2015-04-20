package model.prerequisite;

import model.entity.stats.Stats;

public class RequireCurrentHP extends StatsPrerequisite{
	public RequireCurrentHP(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getCurrentLife() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
