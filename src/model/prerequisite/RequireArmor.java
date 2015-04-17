package model.prerequisite;

import model.entity.stats.Stats;

public class RequireArmor extends StatsPrerequisite{
	RequireArmor(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getArmor() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
