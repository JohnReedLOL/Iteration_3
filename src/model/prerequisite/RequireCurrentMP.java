package model.prerequisite;

import model.entity.stats.Stats;

public class RequireCurrentMP extends StatsPrerequisite{
	public RequireCurrentMP(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getCurrentMana() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
